package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.service.BookingService;
import com.rmit.sept.mon17305.majorproject.service.CustomerService;
import com.rmit.sept.mon17305.majorproject.service.ServiceObjectService;
import com.rmit.sept.mon17305.majorproject.service.WorkerService;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@WebMvcTest(WorkerController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes= WorkerController.class)
public class WorkerControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public WorkerService workerService;
    @MockBean
    public BookingService bookingService;
    @MockBean
    private ServiceObjectService serviceObjectService;
    @MockBean
    private CustomerService customerService;

    public Worker annie = new Worker();

    @BeforeEach
    public void setUp(){
        annie.setUsername("Annie");
        annie.setPassword("0101");
        annie.setFirstName("Annie");
        annie.setLastName("Wanda");
        annie.setCompanyId((long) 007);
        annie.setId((long) 007);
        annie.setStartTime("08:00");
        annie.setFinishTime("16:00");
        annie.setLunchBrTime("11:00");
        annie.setPhone("0456888888");
    }

    @Test
    void getWorkerById_Worker_ifValidId() throws Exception {
        Mockito.when(workerService.getWorker((long)007)).thenReturn(java.util.Optional.ofNullable(annie));
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/api/worker/"+(long)007)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":,\"username\":,\"firstName\":,\"lastName\":,\"created_At\":,\"updated_At\":,\"companyId\":,\"serviceId\":,\"startTime\":,\"finishTime\":,\"password\":,\"lunchBrTime\":,\"type\":,\"userId\":}");

        MvcResult result = mockMvc.perform(request).andReturn();
        //ok
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getWorkerById_returnNothing_ifInvalidId() throws Exception {
        Mockito.when(workerService.getWorker((long)001)).thenReturn(null);
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/api/worker/"+(long)001)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":,\"username\":,\"firstName\":,\"lastName\":,\"created_At\":,\"updated_At\":,\"companyId\":," +
                        "\"serviceId\":,\"startTime\":,\"finishTime\":,\"password\":,\"lunchBrTime\":,\"type\":,\"userId\":}");

        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("invalid id", result.getResponse().getContentAsString());
    }

    @Test
    void getWorkerByUsernameAndPassword_statusFound_validInfo() throws Exception {
        Mockito.when(workerService.getWorkerByUsernameAndPassword(annie.getUsername(), annie.getPassword())).thenReturn(annie);
        String url = "http://localhost:8080/api/worker/username/"+ annie.getUsername()+"/password/"+annie.getPassword();
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //200 is status ok
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getWorkerByUsernameAndPassword_invalidId_invalidUsername() throws Exception {
        Mockito.when(workerService.getWorkerByUsernameAndPassword(annie.getUsername(), annie.getPassword())).thenReturn(annie);
        String url = "http://localhost:8080/api/worker/username/sam/password/"+annie.getPassword();
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("invalid id", result.getResponse().getContentAsString());
    }

    @Test
    void getWorkerByUsernameAndPassword_invalidId_invalidPassword() throws Exception {
        Mockito.when(workerService.getWorkerByUsernameAndPassword(annie.getUsername(), annie.getPassword())).thenReturn(annie);
        String url = "http://localhost:8080/api/worker/username/"+annie.getUsername()+"/password/0000";
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("invalid id", result.getResponse().getContentAsString());
    }


    @Test
    void createNewWorker_statusCreated_validInfo() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();

        String year = today.toString().substring(25);
        String str = today.toString().substring(14,16);
        String date = today.toString().substring(8,10);
        int offsetDate = Integer.parseInt(date)-1;
        String createAt = year+"-"+str+"-"+offsetDate;
        Mockito.when(workerService.saveOrUpdateWorker(annie)).thenReturn(annie);
        RequestBuilder request = MockMvcRequestBuilders.post("http://localhost:8080/api/worker/create")
                .accept(MediaType.APPLICATION_JSON)
                .content(annie.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //201 is status created
        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void getWorkerAvailability_ok_validUrl() throws Exception {
        String url = "http://localhost:8080/api/worker/"+annie.getId()+"/"
                +(long)1+"/"+"2020-09-17"+"/"+"cleaning"+"/"+1+"/";
        Mockito.when(workerService.getWorkerByIdEquals(annie.getId())).thenReturn(annie);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .content(annie.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //200 is status ok
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getWorkerAvailability_badRequest_invalidId() throws Exception {
        String url = "http://localhost:8080/api/worker/"+(-1)+"/"
                +(long)1+"/"+"2020-09-17"+"/"+"cleaning"+"/"+1+"/";
        Mockito.when(workerService.getWorkerByIdEquals(annie.getId())).thenReturn(annie);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .content(annie.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 is status bad request
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void getWorkerAvailability_badRequest_invalidServiceId() throws Exception {
        String url = "http://localhost:8080/api/worker/"+annie.getId()+"/"
                +(-1)+"/"+"2020-09-17"+"/"+"cleaning"+"/"+1+"/";
        Mockito.when(workerService.getWorkerByIdEquals(annie.getId())).thenReturn(annie);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .content(annie.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 is status bad request
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void getWorkerAvailability_badRequest_invalidDate() throws Exception {
        String url = "http://localhost:8080/api/worker/"+annie.getId()+"/"
                +(long)1+"/"+null+"/"+"cleaning"+"/"+1+"/";
        Mockito.when(workerService.getWorkerByIdEquals(annie.getId())).thenReturn(annie);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .content(annie.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 is status bad request
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void getWorkerAvailability_badRequest_invalidDescription() throws Exception {
        String url = "http://localhost:8080/api/worker/"+annie.getId()+"/"
                +(long)1+"/"+"2020-09-17"+"/"+null+"/"+1+"/";
        Mockito.when(workerService.getWorkerByIdEquals(annie.getId())).thenReturn(annie);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .content(annie.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 is status bad request
        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void getWorkerAvailability_badRequest_invalidDuration() throws Exception {
        String url = "http://localhost:8080/api/worker/"+annie.getId()+"/"
                +(long)1+"/"+"2020-09-17"+"/"+"cleaning"+"/"+6+"/";
        Mockito.when(workerService.getWorkerByIdEquals(annie.getId())).thenReturn(annie);
        RequestBuilder request = MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .content(annie.toString())
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        //400 is status bad request
        assertEquals(400, result.getResponse().getStatus());
    }
}
