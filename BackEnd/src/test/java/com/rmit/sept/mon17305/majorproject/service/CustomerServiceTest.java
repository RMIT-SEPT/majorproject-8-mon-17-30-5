package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes= CustomerService.class)
public class CustomerServiceTest {
    @Autowired
    public CustomerService customerService;

    @MockBean
    public CustomerRepository customerRepository;

    public Customer corey = new Customer();

    @BeforeEach
    public void setUp() throws Exception {
        corey.setId((long)1);
        corey.setUsername("CoreyT");
        corey.setFirstName("Corey");
        corey.setLastName("Taylor");
        corey.setBillingAddress("Iowa");
        corey.setShippingAddress("Iowa");
        corey.setPassword("slipknot");
        corey.setPhone("1234567890");
        customerRepository.save(corey);
    }

    @Test
    void saveOrUpdateCustomer_throwNullExcep_invalidCustomer()
    {
        when(customerRepository.save(corey)).thenReturn(null);
        assertThrows(NullPointerException.class, ()-> {
            customerService.saveOrUpdateCustomer(null);
        },"Empty customer cannot be saved");
    }

    @Test
    void saveOrUpdateCustomer_Corey_validCustomer()
    {
        when(customerRepository.save(corey)).thenReturn(corey);
        assertEquals(corey, customerService.saveOrUpdateCustomer(corey));
    }

    @Test
    void getCustomerByUsername_throwNullExcep_invalidUsername(){
        when(customerRepository.findByUsername("CoreyT")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            customerService.getCustomerByUsername("CoreyT");
        }, "username not found");
    }

    @Test
    void getCustomerByUsername_Corey_validUsername(){
        when(customerRepository.findByUsername("CoreyT")).thenReturn(corey);
        assertEquals(corey, customerService.getCustomerByUsername("CoreyT"));
    }

    @Test
    void getCustomerById_throwNullExcep_invalidId() throws Exception {
        when(customerRepository.findById(corey.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            customerService.getCustomerByIdEquals(corey.getId());
        }, "Id not found");
    }

    @Test
    void getCustomer_throwException_IdLessThanOne() throws Exception {
        when(customerRepository.findById(corey.getId())).thenReturn(java.util.Optional.ofNullable(corey));
        assertThrows(Exception.class, ()-> {
            customerService.getCustomer((long) 0);
        }, "Id cannot be less than 1");

    }

    @Test
    void getCustomer_Corey_validId() throws Exception {
        when(customerRepository.findById(corey.getId())).thenReturn(java.util.Optional.ofNullable(corey));
        assertEquals(java.util.Optional.ofNullable(corey), customerService.getCustomer(corey.getId()));
    }

    @Test
    void getCustomerByUsernameAndPassword_throwNullExcep_invalidId()
    {
        when(customerRepository.findByUsernameAndPassword("CoreyT", "slipknot")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            customerService.getCustomerByUsernameAndPassword("CoreyT", "slipknot");
        }, "username not found");
    }

    @Test
    void getCustomerByUsernameAndPassword_Corey_validUsernameAndPassword(){
        when(customerRepository.findByUsernameAndPassword("CoreyT", "slipknot")).thenReturn(corey);
        assertEquals(corey, customerService.getCustomerByUsernameAndPassword("CoreyT", "slipknot"));
    }

    @Test
    void deleteCustomer_throwNullExcep_invalidId() throws Exception {
        when(customerRepository.findByIdEquals(corey.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            customerService.deleteCustomerById(corey.getId());
        }, "Customer cannot be deleted. Id does not exist");
    }

    @Test
    void deleteCustomer_throwException_IdLessThanOne() throws Exception{
        when(customerRepository.findByIdEquals(corey.getId())).thenReturn(corey);
        assertThrows(Exception.class, ()-> {
            customerService.deleteCustomerById((long) 0);
        }, "Id cannot be less than 1");
    }

    @Test
    void getCustomers_throwNullExcep_emptyList(){
        when(customerRepository.findAll()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            customerService.getCustomers();
        }, "No Customers exist");
    }

    @Test
    void getCustomerByIdEquals_throwNullExcep_InvalidId() throws Exception {
        when(customerRepository.findByIdEquals(corey.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            customerService.getCustomerByIdEquals(corey.getId());
        }, "Customer id not found");
    }

    @Test
    void getCustomerByIdEquals_throwException_IdLessThanOne() throws Exception {
        when(customerRepository.findById(corey.getId())).thenReturn(java.util.Optional.ofNullable(corey));
        assertThrows(Exception.class, ()-> {
            customerService.getCustomer((long) 0);
        }, "Id cannot be less than 1");

    }




}
