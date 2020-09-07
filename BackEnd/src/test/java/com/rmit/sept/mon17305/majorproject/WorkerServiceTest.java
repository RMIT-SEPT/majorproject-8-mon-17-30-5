package com.rmit.sept.mon17305.majorproject;


import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.repository.WorkerRepository;
import com.rmit.sept.mon17305.majorproject.service.WorkerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WorkerServiceTest {

    private WorkerService workerService = new WorkerService();
    private Worker judy = new Worker();

    @BeforeAll
    void setup(){
        judy.setId((long)1);
        workerService.saveOrUpdateWorker(judy);
    }

    @Test
    void saveNewWorkerTest(){
        Worker sam = new Worker();
        sam.setId((long)2);
        workerService.saveOrUpdateWorker(sam);
        Optional<Worker> found = workerService.getWorker((long)2);
        assertEquals(sam, found);
    }
}
