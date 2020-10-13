package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.model.Company;
import com.rmit.sept.mon17305.majorproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("")
    public ResponseEntity<?> createNewCompany(@RequestBody Company company, BindingResult result){

        if (result.hasErrors()){
            for(FieldError error: result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        Company company1 = companyService.saveOrUpdateCompany(company);
        return new ResponseEntity<Company>(company, HttpStatus.CREATED);

    }

    @GetMapping("/All")
    public List<Company> getCompanies() {

        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompany(@PathVariable Long id) throws Exception {
        return companyService.getCompany(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceCompany(@RequestBody Company newCompany, @PathVariable Long id) throws Exception {

        companyService.getCompany(id)
                .map(company -> {
                    company.setCompanyName(newCompany.getCompanyName());
                    return new ResponseEntity<Company> (companyService.saveOrUpdateCompany(company),HttpStatus.ACCEPTED);
                })
                .orElseGet(() -> {
                    Company customer1 = companyService.saveOrUpdateCompany(newCompany);
                    return new ResponseEntity<Company>(newCompany, HttpStatus.CREATED);
                });

        return new ResponseEntity<String>("Couldn't find Company", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
    }

}
