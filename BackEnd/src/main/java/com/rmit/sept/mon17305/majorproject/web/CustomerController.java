package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("")
    public ResponseEntity<?> createNewCustomer(@RequestBody Customer customer, BindingResult result){

        if (result.hasErrors()){
            for(FieldError error: result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }

        Customer customer1 = customerService.saveOrUpdateCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();
    }

    @GetMapping("/username/{username}")
    public Customer getCustomerByUsername(@PathVariable String username) {
        return customerService.getCustomerByUsername(username);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        customerService.getCustomer(id)
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getFirstName());
                    return new ResponseEntity<Customer> (customerService.saveOrUpdateCustomer(customer),HttpStatus.ACCEPTED);
                })
                .orElseGet(() -> {
                    Customer customer1 = customerService.saveOrUpdateCustomer(newCustomer);
                    return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
                });

        return new ResponseEntity<String>("Couldn't find Customer", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

}
