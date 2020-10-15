package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.OngoingStubbing;
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
@ContextConfiguration(classes= AdminService.class)

public class AdminServiceTest {

    @Autowired
    public AdminService adminService;

    @MockBean
    public AdminRepository adminRepository;

    public Admin cathy = new Admin();

    @BeforeEach
    public void setUp() throws Exception {
        cathy.setId((long) 1);
        cathy.setFirstName("Cathy");
        cathy.setLastName("Ropkhop");
        cathy.setUsername("cathy");
        cathy.setPassword("1111");
        cathy.setPhone("0490123456");
        adminRepository.save(cathy);
    }

    @Test
    void saveOrUpdateAdmin_throwNullExcep_invalidAdmin() {
        when(adminRepository.save(cathy)).thenReturn(null);
        assertThrows(NullPointerException.class, ()-> {
            adminService.saveOrUpdateAdmin(null);
        },"Empty admin cannot be saved");
    }

    @Test
    void saveOrUpdateAdmin_Cathy_validAdmin()
    {
        when(adminRepository.save(cathy)).thenReturn(cathy);
        assertEquals(cathy, adminService.saveOrUpdateAdmin(cathy));
    }

    @Test
    void getAdminByUsername_throwNullExcep_invalidUsername(){
        when(adminRepository.findByUsername("cathy")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            adminService.getAdminByUsername("cathy");
        }, "username not found");
    }

    @Test
    void getAdminByUsername_Cathy_validUsername(){
        when(adminRepository.findByUsername("cathy")).thenReturn(cathy);
        assertEquals(cathy, adminService.getAdminByUsername("cathy"));
    }


    @Test
    void getAdminById_throwNullExcep_invalidId() throws Exception {
        when(adminRepository.findById(cathy.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            adminService.getAdminByIdEquals(cathy.getId());
        }, "Id not found");
    }

    @Test
    void getAdmin_throwException_IdLessThanOne() throws Exception {
        when(adminRepository.findById(cathy.getId())).thenReturn(java.util.Optional.ofNullable(cathy));
        assertThrows(Exception.class, ()-> {
            adminService.getAdmin((long) 0);
        }, "Id cannot be less than 1");

    }

    @Test
    void getAdmin_Cathy_validId() throws Exception {
        when(adminRepository.findById(cathy.getId())).thenReturn(java.util.Optional.ofNullable(cathy));
        assertEquals(java.util.Optional.ofNullable(cathy), adminService.getAdmin(cathy.getId()));
    }

    @Test
    void getCustomerByUsernameAndPassword_throwNullExcep_invalidId()
    {
        when(adminRepository.findByUsernameAndPassword("cathy", "1111")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            adminService.getAdminByUsernameAndPassword("cathy", "1111");
        }, "username not found");
    }

    @Test
    void getAdminByUsernameAndPassword_Cathy_validUsernameAndPassword(){
        when(adminRepository.findByUsernameAndPassword("cathy", "1111")).thenReturn(cathy);
        assertEquals(cathy, adminService.getAdminByUsernameAndPassword("cathy", "1111"));
    }

    @Test
    void deleteAdmin_throwNullExcep_invalidId() throws Exception {
        when(adminRepository.findByIdEquals(cathy.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            adminService.deleteAdminById(cathy.getId());
        }, "Admin cannot be deleted. Id does not exist");
    }

    @Test
    void deleteAdmin_throwException_IdLessThanOne() throws Exception{
        when(adminRepository.findByIdEquals(cathy.getId())).thenReturn(cathy);
        assertThrows(Exception.class, ()-> {
            adminService.deleteAdminById((long) 0);
        }, "Id cannot be less than 1");
    }

    @Test
    void getAdminByIdEquals_throwNullExcep_InvalidId() throws Exception {
        when(adminRepository.findByIdEquals(cathy.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            adminService.getAdminByIdEquals(cathy.getId());
        }, "Admin id not found");
    }

    @Test
    void getAdminByIdEquals_throwException_IdLessThanOne() throws Exception {
        when(adminRepository.findById(cathy.getId())).thenReturn(java.util.Optional.ofNullable(cathy));
        assertThrows(Exception.class, ()-> {
            adminService.getAdmin((long) 0);
        }, "Id cannot be less than 1");

    }
}

