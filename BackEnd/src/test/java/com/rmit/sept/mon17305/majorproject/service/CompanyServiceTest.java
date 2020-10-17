package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.repository.CompanyRepository;
import com.rmit.sept.mon17305.majorproject.repository.WorkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes= CompanyService.class)
public class CompanyServiceTest {

    @Autowired
    public CompanyService companyService;
    @MockBean
    public CompanyRepository companyRepository;

    public Company business1 = new Company();

    @BeforeEach
    public void setUp(){
        business1.setId((long)1);
        business1.setCompanyName("Tim Car Wash");
        companyRepository.save(business1);
    }

    @Test
    void getCompany_throwException_IdLessThanOne(){
        when(companyRepository.findById(business1.getId())).thenReturn(java.util.Optional.ofNullable(business1));
        assertThrows(Exception.class, () -> {
            companyService.getCompany((long)0);
        }, "id cannot be less than 1");
    }

    @Test
    void getCompany_nullException_IdnotExisted(){
        when(companyRepository.findById(business1.getId())).thenReturn(java.util.Optional.ofNullable(business1));
        assertThrows(Exception.class, () -> {
            companyService.getCompany((long)2);
        }, "id not found");
    }

    @Test
    void getCompany_business1_Id1() throws Exception {
        when(companyRepository.findById(business1.getId())).thenReturn(java.util.Optional.ofNullable(business1));
        assertTrue(companyService.getCompany(business1.getId()).toString().contains(business1.toString()));
    }

    @Test
    void saveOrUpdateCompany_throwNullExcep_invalidCompany()
    {
        when(companyRepository.save(business1)).thenReturn(null);
        assertThrows(NullPointerException.class, ()-> {
            companyService.saveOrUpdateCompany(null);
        },"Empty company cannot be saved");
    }

    @Test
    void saveOrUpdateCompany_business1_validCompany()
    {
        when(companyRepository.save(business1)).thenReturn(business1);
        assertEquals(business1, companyService.saveOrUpdateCompany(business1));
    }

    @Test
    void getCompanyByCompanyName_throwNullExcep_invalidCompanyName(){
        when(companyRepository.findByCompanyName("Tim Car Wash")).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            companyService.getCompanyByCompanyName("Tim Car Wash");
        }, "Company name not found");
    }

    @Test
    void getCompanyByCompanyName_TimCarWash_validCompanyName(){
        when(companyRepository.findByCompanyName("Tim Car Wash")).thenReturn(business1);
        assertEquals(business1, companyService.getCompanyByCompanyName("Tim Car Wash"));
    }

    @Test
    void deleteCompany_throwNullExcep_invalidId() throws Exception {
        when(companyRepository.findByIdEquals(business1.getId())).thenReturn(null);
        assertThrows(NullPointerException.class, () -> {
            companyService.deleteCompanyById(business1.getId());
        }, "Company cannot be deleted. Id does not exist");
    }

    @Test
    void deleteCompany_throwException_IdLessThanOne() throws Exception{
        when(companyRepository.findById(business1.getId())).thenReturn(Optional.ofNullable(business1));
        assertThrows(Exception.class, ()-> {
            companyService.deleteCompanyById((long) 0);
        }, "Id cannot be less than 1");
    }


}
