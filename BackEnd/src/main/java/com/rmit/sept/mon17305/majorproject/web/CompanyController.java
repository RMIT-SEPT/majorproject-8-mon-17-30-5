package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("")
    public ResponseEntity<Company> createNewCustomer(@RequestBody Company company){

        Company company1 = companyService.saveOrUpdateCompany(company);
        return new ResponseEntity<Company>(company, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public List<Company> getCompanies() {

        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompany(@PathVariable Long id) {
        return companyService.getCompany(id);
    }

}
