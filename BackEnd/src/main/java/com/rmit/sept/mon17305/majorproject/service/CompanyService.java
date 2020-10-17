package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveOrUpdateCompany(Company company){
        if(company==null)
        {
            throw new NullPointerException("Empty company cannot be saved");
        }
        //business logic
        return companyRepository.save(company);

    }


    public List<Company> getCompanies(){
        List<Company> companyList = companyRepository.findAll();
        if(companyList==null)
        {
            throw new NullPointerException("No Company exist");
        }
        return companyRepository.findAll();
    }


    public Optional<Company> getCompany(Long id) throws Exception {
        if(id < 1){
            throw new Exception("id cannot be less than 1");
        }
        Optional<Company> ret = companyRepository.findById(id);
        if(!ret.isPresent()){
            throw new NullPointerException("id not found");
        }
        return ret;
    }

    public void deleteCompanyById(Long id) throws Exception {
        if(id<1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Optional<Company> company = companyRepository.findById(id);
        if(!company.isPresent())
        {
            throw new NullPointerException("Company cannot be deleted. Id does not exist");
        }
        companyRepository.deleteById(id);
    }



    public Company getCompanyByCompanyName(String companyname){
        Company company = companyRepository.findByCompanyName(companyname);
        if(company==null)
        {
            throw new NullPointerException("Company name not found");
        }
        return companyRepository.findByCompanyName(companyname);
    }


    public Company getCompanyByIdEquals(Long id) throws Exception{
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Company company = companyRepository.findByIdEquals(id);
        if(company==null)
        {
            throw new NullPointerException("Company id not found");
        }
        return companyRepository.findByIdEquals(id);
    }



}