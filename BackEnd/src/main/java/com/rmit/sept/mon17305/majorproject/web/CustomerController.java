package com.rmit.sept.mon17305.majorproject.web;

import com.rmit.sept.mon17305.majorproject.CustomedException.CustomerException;
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
@CrossOrigin(origins="http://majorproject-sept.s3-website-us-east-1.amazonaws.com")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewCustomer(@RequestBody Customer customer, BindingResult result) throws CustomerException {

        if (result.hasErrors()){
            for(FieldError error: result.getFieldErrors()) {
                return new ResponseEntity<List<FieldError>>(result.getFieldErrors(), HttpStatus.BAD_REQUEST);
            }
        }
        if(customer.getUsername().length() < 3){
            throw new CustomerException("Username must contain at least 3 characters");
        }else if(customer.getFirstName().length()<3){
            throw new CustomerException("FirstName must contain at least 3 characters");
        }else if(customer.getLastName().length()<3){
            throw new CustomerException("LastName must contain at least 3 characters");
        }
        Customer customer1 = customerService.saveOrUpdateCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getCustomerByUsername(@PathVariable String username) {
        Customer cust = customerService.getCustomerByUsername(username);
        if(cust != null){
            return new ResponseEntity<Customer>(cust, HttpStatus.FOUND);

        }
        return new ResponseEntity<String>("invalid username", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/username/{username}/password/{password}")
    public ResponseEntity<?> getCustomerByUsernameAndPassword(@PathVariable String username, @PathVariable String password) throws CustomerException {
        if(username.isEmpty()){
            throw new CustomerException("Username cannot be empty");
        }
        else if(username.length() < 3){
            throw new CustomerException("Username must contain at least 3 characters");
        }
        else if(password.isEmpty()){
            throw new CustomerException("Password cannot be empty");
        }
        Customer customer = customerService.getCustomerByUsernameAndPassword(username, password);
        if(customer == null){
            throw new NullPointerException("Wrong user details");
        }

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
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
