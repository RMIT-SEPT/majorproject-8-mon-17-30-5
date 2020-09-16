package com.rmit.sept.mon17305.majorproject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.service.WorkerService;
import com.rmit.sept.mon17305.majorproject.web.WorkerController;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

@WebMvcTest(WorkerController.class)
public class MajorprojectApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WorkerService service1;


    public void setUp_worker() {
        Worker worker1 = new Worker();
        worker1.setId((long)1);
        worker1.setFirstName("Daniel");
        worker1.setLastName("Sample");
        //worker1.setWorkingDays("Mon/Tue/Wed");
        worker1.setCompanyId((long) 001);
        //worker1.setServiceId((long) 001);
        worker1.setStartTime("08:00");
        worker1.setFinishTime("16:00");

        service1.saveOrUpdateWorker(worker1);
    }

    //no exception should be thrown when given information are all valid
    @Test
    public void test_create_worker() throws Exception {

        Object randomObj = new Object() {
            public final String firstName = "Ethan";
            public final String lastName = "Daniels";
        };

        Object randomObj2 = new Object() {
            public final String firstName = "Tom";
            public final String lastName = "Downs";
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);
        String json2 = objectMapper.writeValueAsString(randomObj2);

        this.mockMvc.perform(post("http://localhost:8080/api/worker")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());

        this.mockMvc.perform(post("http://localhost:8080/api/worker")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());

    }

    @Test
    public void test_get_worker() throws Exception {

        Object randomObj = new Object() {
            public final String firstName = "Steve" ;
            public final String lastName = "Daniels";

        };

        Object randomObj2 = new Object() {
            public final long id = 2;
            public final String firstName = "Tom";
            public final String lastName = "Downs";
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);
        String json2 = objectMapper.writeValueAsString(randomObj2);

        this.mockMvc.perform(post("http://localhost:8080/api/worker")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());

        this.mockMvc.perform(post("http://localhost:8080/api/worker")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());

        this.mockMvc.perform(get("http://localhost:8080/api/worker/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Tom"));
    }

}