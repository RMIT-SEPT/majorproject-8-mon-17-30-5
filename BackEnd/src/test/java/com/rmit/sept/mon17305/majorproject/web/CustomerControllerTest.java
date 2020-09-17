package com.rmit.sept.mon17305.majorproject.web;
import com.rmit.sept.mon17305.majorproject.CustomedException.CustomerException;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.service.AdminService;
import com.rmit.sept.mon17305.majorproject.service.CustomerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import javax.validation.constraints.AssertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes= CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public CustomerService customerService;

    public Customer austin = new Customer();

    @BeforeEach
    void setUp(){
        austin.setFirstName("Austin");
        austin.setLastName("Mctakish");
        austin.setBillingAddress("20 lala Land");
        austin.setShippingAddress("20 lala Land");
        austin.setUsername("Austin");
        austin.setPassword("Mctakish");
        austin.setId((long)1);
    }

    @Test
    void getCustomerByUsername_found_validUsername() throws Exception {
        Mockito.when(customerService.getCustomerByUsername(austin.getUsername())).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/api/customer/username/"+austin.getUsername())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //found = 302
        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    void getCustomerByUsername_badRequest_invalidUsername() throws Exception {
        Mockito.when(customerService.getCustomerByUsername(austin.getUsername())).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/api/customer/username/jennie")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //bad request = 400
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void getCustomerByUsernameAndPassword_customer_valid() throws Exception {
        String url = "http://localhost:8080/api/customer/username/"+austin.getUsername()+"/password/"+austin.getPassword()+"/";
        Mockito.when(customerService.getCustomerByUsernameAndPassword(austin.getUsername(), austin.getPassword())).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();
        //found = 302
        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    void getCustomerByUsernameAndPassword_throwException_invalidUsername() throws Exception {
        String url = "http://localhost:8080/api/customer/username/au"+"/password/"+austin.getPassword()+"/";
        Mockito.when(customerService.getCustomerByUsernameAndPassword(austin.getUsername(), austin.getPassword())).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        Exception e = assertThrows(Exception.class,()->{
            MvcResult result = mockMvc.perform(request).andReturn();
        });
        String expect = "Username must contain at least 3 characters";
        String actual = e.getMessage();
        assertTrue(actual.contains(expect));
    }

    @Test
    void getCustomerByUsernameAndPassword_throwException_invalidUserDetails() throws Exception {
        String url = "http://localhost:8080/api/customer/username/anna"+"/password/"+austin.getPassword()+"/";
        Mockito.when(customerService.getCustomerByUsernameAndPassword(austin.getUsername(), austin.getPassword())).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        Exception e = assertThrows(Exception.class,()->{
            MvcResult result = mockMvc.perform(request).andReturn();
        });
        String expect = "Wrong user details";
        String actual = e.getMessage();
        assertTrue(actual.contains(expect));
    }

    @Test
    void createNewCustomer_Created_validInfo() throws Exception {
        Mockito.when(customerService.saveOrUpdateCustomer(austin)).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/customer/create")
                .accept(MediaType.APPLICATION_JSON)
                .content(austin.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //201 is status created
        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void createNewCustomer_ThrowException_invalidUsername() throws Exception {
        austin.setUsername("au");
        Mockito.when(customerService.saveOrUpdateCustomer(austin)).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/customer/create")
                .accept(MediaType.APPLICATION_JSON)
                .content(austin.toString())
                .contentType(MediaType.APPLICATION_JSON);

        //MvcResult result = mockMvc.perform(request).andReturn();
        //400 bad request
        Exception e = assertThrows(Exception.class,()->{
            MvcResult result = mockMvc.perform(request).andReturn();
        });
        String expect = "Username must contain at least 3 characters";
        String actual = e.getMessage();
        assertTrue(actual.contains(expect));
    }

    @Test
    void createNewCustomer_ThrowException_invalidFirstName() throws Exception {
        austin.setFirstName("au");
        Mockito.when(customerService.saveOrUpdateCustomer(austin)).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/customer/create")
                .accept(MediaType.APPLICATION_JSON)
                .content(austin.toString())
                .contentType(MediaType.APPLICATION_JSON);

        //MvcResult result = mockMvc.perform(request).andReturn();
        //400 bad request
        Exception e = assertThrows(Exception.class,()->{
            MvcResult result = mockMvc.perform(request).andReturn();
        });
        String expect = "FirstName must contain at least 3 characters";
        String actual = e.getMessage();
        assertTrue(actual.contains(expect));
    }
    @Test
    void createNewCustomer_ThrowException_invalidLastName() throws Exception {
        austin.setLastName("M");
        Mockito.when(customerService.saveOrUpdateCustomer(austin)).thenReturn(austin);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/customer/create")
                .accept(MediaType.APPLICATION_JSON)
                .content(austin.toString())
                .contentType(MediaType.APPLICATION_JSON);

        //400 bad request
        Exception e = assertThrows(Exception.class,()->{
            MvcResult result = mockMvc.perform(request).andReturn();
        });
        String expect = "LastName must contain at least 3 characters";
        String actual = e.getMessage();
        assertTrue(actual.contains(expect));
    }
}
