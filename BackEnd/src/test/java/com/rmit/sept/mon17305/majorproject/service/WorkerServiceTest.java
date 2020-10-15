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

import java.util.ArrayList;
import java.util.List;

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

    public Worker Mick = new Worker();

    @BeforeEach
    public void setUp(){
        Mick.setId((long)1);
        Mick.setFirstName("Mick");
        Mick.setLastName("Thomson");
        Mick.setUsername("Mick");
        Mick.setPassword("2222");
        Mick.setStartTime("08:00");
        Mick.setFinishTime("16:00");
        Mick.setLunchBrTime("11:00");
        Mick.setCompanyId((long)1);
        Mick.setPhone("0488456000");
        workerRepository.save(Mick);
    }
    @Test
    void saveOrUpdateWorker_throwNullExcep_invalidWorker()
    {
        when(workerRepository.save(Mick)).thenReturn(null);
        assertThrows(NullPointerException.class, ()-> {
            workerService.saveOrUpdateWorker(null);
        },"Empty worker cannot be saved");
    }

    @Test
    void saveOrUpdateWorker_Mick_validCustomer()
    {
        when(workerRepository.save(Mick)).thenReturn(Mick);
        assertEquals(Mick, workerService.saveOrUpdateWorker(Mick));
    }

    @Test
    void getWorkerByUsername_throwNullExcep_invalidUsername(){
        when(workerRepository.findByUsername("Mick")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkerByUsername("Mick");
        }, "username not found");
    }

    @Test
    void getWorkerByUsername_Mick_validUsername(){
        when(workerRepository.findByUsername("Mick")).thenReturn(Mick);
        assertEquals(Mick, workerService.getWorkerByUsername("Mick"));
    }

    @Test
    void getWorkers_throwNullExcep_emptyList(){
        when(workerRepository.findAll()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkers();
        }, "No Workers exist");
    }

    @Test
    void getWorkerByUsernameAndPassword_throwNullExcep_invalidUsernameAndPassword()
    {
        when(workerRepository.findByUsernameAndPassword("Mick", "2222")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkerByUsername("Mick");
        }, "Username and password don't exist");
    }

    @Test
    void getWorkerByUsernameAndPassword_Mick_validUsernameAndPassword()
    {
        when(workerRepository.findByUsernameAndPassword("Mick", "2222")).thenReturn(Mick);
        assertEquals(Mick, workerService.getWorkerByUsernameAndPassword("Mick", "2222"));
    }

    @Test
    void getWorkerByIdEquals_throwNullExcep_invalidId()
    {
        when(workerRepository.findByIdEquals(Mick.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkerByIdEquals(Mick.getId());
        }, "Id does not exist");
    }

    @Test
    void getWorkerByIdEquals_throwException_LessThanOne()
    {
        when(workerRepository.findByIdEquals(Mick.getId())).thenReturn(Mick);
        assertThrows(Exception.class, ()-> {
            workerService.getWorkerByIdEquals((long)0);
        }, "Id cannot be less than 1");
    }

    @Test
    void getWorkerByIdEquals_Mick_validId() throws Exception {
        when(workerRepository.findByIdEquals(Mick.getId())).thenReturn(Mick);
        assertEquals(Mick, workerService.getWorkerByIdEquals(Mick.getId()));
    }

    @Test
    void getWorker_throwNullExcep_invalidId()
    {
        when(workerRepository.findById(Mick.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkerByIdEquals(Mick.getId());
        }, "Id does not exist");
    }

    @Test
    void getWorker_throwException_LessThanOne()
    {
        when(workerRepository.findById(Mick.getId())).thenReturn(java.util.Optional.ofNullable(Mick));
        assertThrows(Exception.class, ()-> {
            workerService.getWorkerById((long)0);
        }, "Id cannot be less than 1");
    }

    @Test
    void getWorker_Mick_validId() throws Exception {
        when(workerRepository.findByIdEquals(Mick.getId())).thenReturn(Mick);
        assertEquals(Mick, workerService.getWorkerById(Mick.getId()));
    }

    @Test
    void deleteWorker_throwNullExcep_invalidId()
    {
        when(workerRepository.findByIdEquals(Mick.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkerByIdEquals(Mick.getId());
        }, "Id does not exist");
    }

    @Test
    void deleteWorker_throwException_LessThanOne()
    {
        when(workerRepository.findByIdEquals(Mick.getId())).thenReturn(Mick);
        assertThrows(Exception.class, ()-> {
            workerService.getWorkerByIdEquals((long)0);
        }, "Id cannot be less than 1");
    }

    @Test
    void getWorkerById_throwNullExcep_invalidId()
    {
        when(workerRepository.findById(Mick.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkerByIdEquals(Mick.getId());
        }, "Id does not exist");
    }

    @Test
    void getWorkerById_throwException_LessThanOne()
    {
        when(workerRepository.findById(Mick.getId())).thenReturn(java.util.Optional.ofNullable(Mick));
        assertThrows(Exception.class, ()-> {
            workerService.getWorkerById((long)0);
        }, "Id cannot be less than 1");
    }

    @Test
    void getWorkerById_Mick_validId() throws Exception {
        when(workerRepository.findByIdEquals(Mick.getId())).thenReturn(Mick);
        assertEquals(Mick, workerService.getWorkerById(Mick.getId()));
    }

    @Test
    void getWorkersByCompany_throwNullExcep_invalidId()
    {
        when(workerRepository.findByCompanyIdEquals(Mick.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            workerService.getWorkersByCompanyId(Mick.getId());
        }, "No workers exist for company");
    }

    @Test
    void getWorkersByCompany_throwException_LessThanOne()
    {   List<Worker> list = new ArrayList<Worker>();
        list.add(0, Mick);

        when(workerRepository.findByCompanyIdEquals(Mick.getId())).thenReturn(list);
        assertThrows(Exception.class, ()-> {
            workerService.getWorkersByCompanyId((long)0);
        }, "Company id cannot be less than 1");
    }

}
