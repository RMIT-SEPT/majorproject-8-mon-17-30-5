package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.repository.ServiceObjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes= ServiceObjectService.class)
public class ServiceObjectServiceTest {

    @Autowired
    public ServiceObjectService serviceObjectService;
    @MockBean
    public ServiceObjectRepository serviceObjectRepository;

    public ServiceObject carWash = new ServiceObject();

    @BeforeEach
    public void setUp(){
        carWash.setId((long)1);
        carWash.setCompanyId((long)1);
        carWash.setDescription("car wash");
        carWash.setDuration(2);
    }

    @Test
    void saveOrUpdateServiceObject_carWash_validInfo() throws Exception {
        when(serviceObjectRepository.save(carWash)).thenReturn(carWash);
        assertEquals(carWash, serviceObjectService.saveOrUpdateServiceObject(carWash));
    }

    @Test
    void saveOrUpdateServiceObject_NullPtrExceptThrown_nullService(){
        assertThrows(NullPointerException.class, ()->{
            serviceObjectService.saveOrUpdateServiceObject(null);
        }, "null service object");
    }

    @Test
    void saveOrUpdateServiceObject_ExceptThrown_invalidCompanyId(){
        carWash.setCompanyId((long)-1);
        assertThrows(Exception.class, ()->{
            serviceObjectService.saveOrUpdateServiceObject(carWash);
        }, "invalid company id");
    }

    @Test
    void saveOrUpdateServiceObject_ExceptThrown_invalidDurationLess(){
        carWash.setDuration(0);
        assertThrows(Exception.class, ()->{
            serviceObjectService.saveOrUpdateServiceObject(carWash);
        }, "invalid duration");
    }

    @Test
    void saveOrUpdateServiceObject_ExceptThrown_invalidDurationMore(){
        carWash.setDuration(14);
        assertThrows(Exception.class, ()->{
            serviceObjectService.saveOrUpdateServiceObject(carWash);
        }, "invalid duration");
    }

    @Test
    void saveOrUpdateServiceObject_NullPtrExceptThrown_ServiceCannotSave(){
        when(serviceObjectRepository.save(carWash)).thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            serviceObjectService.saveOrUpdateServiceObject(carWash);
        }, "cannot save");
    }

    @Test
    void getServiceObjects_servicesList_serviceExisted(){
        List<ServiceObject> list = new ArrayList<ServiceObject>();
        list.add(0, carWash);
        when(serviceObjectRepository.findAll()).thenReturn(list);
        assertEquals(list, serviceObjectService.getServiceObjects());
    }

    @Test
    void getServiceObjects_nullptrExcept_noServiceExisted(){
        when(serviceObjectRepository.findAll()).thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            serviceObjectService.getServiceObjects();
        },"currently no service");
    }

    @Test
    void getServiceObject_serviceObject_validId(){
        when(serviceObjectRepository.findById(carWash.getId())).thenReturn(java.util.Optional.ofNullable(carWash));
        assertTrue(serviceObjectService.getServiceObject(carWash.getId()).toString()
        .contains(carWash.toString()));
    }

    @Test
    void deleteServiceObjectById_success_validId() throws Exception {
        assertDoesNotThrow(()->{serviceObjectService
                .deleteServiceObjectById(carWash.getId());});
    }

    @Test
    void deleteServiceObjectById_exceptThrown_invalidId(){
        serviceObjectRepository.save(carWash);
        carWash.setId((long)-1);
        assertThrows(Exception.class, ()->{
            serviceObjectService.deleteServiceObjectById(carWash.getId());
        }, "invalid id");
    }

    @Test
    void getServiceDescriptionById_description_validId() throws Exception {
        when(serviceObjectRepository.findByIdEquals(carWash.getId())).thenReturn(carWash);
        assertEquals(carWash.getDescription(), serviceObjectService
        .getServiceDescriptionById(carWash.getId()));
    }

    @Test
    void getServiceDescriptionById_ExceptThrown_invalidId(){
        carWash.setId((long)-1);
        assertThrows(Exception.class, ()->{
            serviceObjectService.getServiceDescriptionById(carWash.getId());
        },"invalid id");
    }

    @Test
    void getServiceDescriptionById_NullExceptThrown_ServiceNotFound(){
        when(serviceObjectRepository.findByIdEquals(carWash.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            serviceObjectService.getServiceDescriptionById(carWash.getId());
        },"cannot find service with id given");
    }

    @Test
    void getServiceDescriptionById_ExceptThrown_DescriptionInvalid(){
        carWash.setDescription("");
        when(serviceObjectRepository.findByIdEquals(carWash.getId())).thenReturn(carWash);
        assertThrows(Exception.class, ()->{
            serviceObjectService.getServiceDescriptionById(carWash.getId());
        },"invalid description");
    }

    @Test
    void getServiceObjectsByCompanyId_serviceList_validCompanyId() throws Exception {
        List<ServiceObject> list = new ArrayList<ServiceObject>();
        list.add(0, carWash);
        when(serviceObjectRepository.findByCompanyIdEquals(carWash.getCompanyId()))
                .thenReturn(list);
        assertEquals(list, serviceObjectService
                .getServiceObjectsByCompanyId(carWash.getCompanyId()));
    }

    @Test
    void getServiceObjectsByCompanyId_ExceptThrown_invalidCompanyId(){
        carWash.setCompanyId((long)-1);
        assertThrows(Exception.class, ()->{
            serviceObjectService.getServiceObjectsByCompanyId(carWash.getCompanyId());
        }, "invalid id");
    }

    @Test
    void getServiceObjectsByCompanyId_NullPtrExceptThrown_invalidCompanyId(){
        when(serviceObjectRepository.findByCompanyIdEquals(carWash.getCompanyId()))
                .thenReturn(null);
        assertThrows(NullPointerException.class, ()->{
            serviceObjectService.getServiceObjectsByCompanyId(carWash.getCompanyId());
        }, "cannot find services for company");
    }
}
