package com.rmit.sept.mon17305.majorproject.service;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveOrUpdateCustomer(Customer customer){

        //business logic
        return customerRepository.save(customer);

    }

    public List<Customer> getCustomers(){

        return customerRepository.findAll();

    }

    public Optional<Customer> getCustomer(Long id){

        return customerRepository.findById(id);
    }

    public Customer getCustomerByUsername(String username){

        return customerRepository.findByUsername(username);
    }

    public Customer getCustomerByUsernameAndPassword(String username, String password){

        return customerRepository.findByUsernameAndPassword(username, password);
    }

    public void deleteCustomerById(Long id){

        customerRepository.deleteById(id);
    }



}
