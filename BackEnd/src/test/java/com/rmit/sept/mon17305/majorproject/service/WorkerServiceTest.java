package com.rmit.sept.mon17305.majorproject.service;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.repository.WorkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes= WorkerService.class)
public class WorkerServiceTest {

    @Autowired
    public WorkerService workerService;

    @MockBean
    public WorkerRepository workerRepository;

    public Worker mack = new Worker();

    @BeforeEach
    public void setUp(){
        mack.setFirstName("Mack");
        mack.setLastName("MackerMc");
        mack.setUsername("Mack");
        mack.setPassword("2222");
        mack.setStartTime("08:00");
        mack.setFinishTime("16:00");
        mack.setLunchBrTime("11:00");
        mack.setCompanyId((long)1);
        mack.setPhone("0488456000");
    }

    @Test
    void getWorkerByUsername_throwNullExcep_invalidUsername(){
        when(workerRepository.findByUsername("Mack")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkerByUsername("Mack");
        }, "username not found");
    }

    @Test
    void getWorkerByUsername_Mack_invalidUsername(){
        when(workerRepository.findByUsername("Mack")).thenReturn(mack);
        assertEquals(mack, workerService.getWorkerByUsername("Mack"));
    }
}
