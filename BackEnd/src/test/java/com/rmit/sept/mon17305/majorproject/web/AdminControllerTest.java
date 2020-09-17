package com.rmit.sept.mon17305.majorproject.web;
import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.service.AdminService;
import com.rmit.sept.mon17305.majorproject.service.WorkerService;
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


import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes= AdminController.class)
public class AdminControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public AdminService adminService;

    public Admin cathy = new Admin();
//    public String todayDate =  "";
//
//    @BeforeAll
//    void setTodayDateFormat(){
//        Date today = new Date();
//        String year = today.toString().substring(25);
//        String mon = today.toString().substring(4,7);
//        String date = today.toString().substring(8,10);
//        int offsetDate = Integer.parseInt(date)-1;
//        System.out.println(year+"+"+mon+"+"+date);
//        todayDate = year+"-"+getMonth(mon)+"-"+offsetDate;
//    }



    @BeforeEach
    void setUp(){
        cathy.setFirstName("Cathy");
        cathy.setLastName("Ropkhop");
        cathy.setUsername("cathy");
        cathy.setPassword("1234");
        cathy.setCompanyId((long)1);
        cathy.setId((long)1);
    }

    @Test
    void createNewAdmin_statusCreated_validInfo() throws Exception {

        Mockito.when(adminService.saveOrUpdateAdmin(cathy)).thenReturn(cathy);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/admin")
                .accept(MediaType.APPLICATION_JSON)
                .content(cathy.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void createNewAdmin_statusBadRequest_invalidUsername() throws Exception {
        cathy.setUsername("C");
        Mockito.when(adminService.saveOrUpdateAdmin(cathy)).thenReturn(cathy);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/admin")
                .accept(MediaType.APPLICATION_JSON)
                .content(cathy.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 = bad request
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void createNewAdmin_statusBadRequest_invalidFirstName() throws Exception {
        cathy.setFirstName("Ca");
        Mockito.when(adminService.saveOrUpdateAdmin(cathy)).thenReturn(cathy);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/admin")
                .accept(MediaType.APPLICATION_JSON)
                .content(cathy.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 = bad request
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void createNewAdmin_statusBadRequest_invalidBlankLastName() throws Exception {
        cathy.setLastName("");
        Mockito.when(adminService.saveOrUpdateAdmin(cathy)).thenReturn(cathy);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/admin")
                .accept(MediaType.APPLICATION_JSON)
                .content(cathy.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 = bad request
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void createNewAdmin_statusBadRequest_nullComId() throws Exception {
        cathy.setCompanyId(null);
        Mockito.when(adminService.saveOrUpdateAdmin(cathy)).thenReturn(cathy);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/admin")
                .accept(MediaType.APPLICATION_JSON)
                .content(cathy.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 = bad request
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void getAdmin_admin_validId() throws Exception {
        Mockito.when(adminService.getAdmin(cathy.getId())).thenReturn(java.util.Optional.ofNullable(cathy));
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/api/admin/"+cathy.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
               .content("{\"id\":,\"username\":,\"firstName\":,\"lastName\":,\"created_At\":,\"updated_At\":,\"companyId\":,\"serviceId\":,\"startTime\":,\"finishTime\":,\"password\":,\"lunchBrTime\":,\"type\":,\"userId\":}");

        MvcResult result = mockMvc.perform(request).andReturn();
        //status found 302
        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    void getAdmin_admin_invalidId() throws Exception {
        //Mockito.when(adminService.getAdmin(cathy.getId())).thenReturn(java.util.Optional.ofNullable(cathy));
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/api/admin/"+(long)4)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":,\"username\":,\"firstName\":,\"lastName\":,\"created_At\":,\"updated_At\":,\"companyId\":,\"serviceId\":,\"startTime\":,\"finishTime\":,\"password\":,\"lunchBrTime\":,\"type\":,\"userId\":}");

        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(400, result.getResponse().getStatus());
    }


//    public String getMonth(String str){
//        String ret = "";
//        if(str == "Jan"){
//            ret =  "01";
//        }else if(str == "Feb"){
//            ret =  "02";
//        }else if(str == "Mar"){
//            ret =  "03";
//        }else if(str == "Apr"){
//            ret =  "04";
//        }else if(str == "May"){
//            ret = "05";
//        }else if(str == "Jun"){
//            ret = "06";
//        }else if(str == "Jul"){
//            ret = "07";
//        }else if(str == "Aug"){
//            ret = "08";
//        }else if(str.equals("Sep")){
//            ret =  "09";
//        }else if(str == "Oct"){
//            ret = "10";
//        }else if(str == "Nov"){
//            ret = "11";
//        }else if(str == "Dec"){
//            ret = "12";
//        }
//
//        return ret;
//    }
}
