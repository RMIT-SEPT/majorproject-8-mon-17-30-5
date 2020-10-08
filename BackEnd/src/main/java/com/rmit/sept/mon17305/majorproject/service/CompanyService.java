package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.model.Company;
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

        //business logic
        return companyRepository.save(company);

    }

    public List<Company> getCompanies(){

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

    public void deleteCompanyById(Long id){

        companyRepository.deleteById(id);
    }

}