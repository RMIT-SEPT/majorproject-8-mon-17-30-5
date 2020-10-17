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
        if(customer == null)
        {
            throw new NullPointerException("Empty customer cannot be saved");
        }
        //business logic
        return customerRepository.save(customer);

    }

    public List<Customer> getCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        if(customerList == null)
        {
            throw new NullPointerException("No Customers exist");
        }
        return customerRepository.findAll();

    }

    public Optional<Customer> getCustomer(Long id) throws Exception{
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent())
        {
            throw new NullPointerException("Customer id not found");
        }
        return customerRepository.findById(id);
    }

    public Customer getCustomerByUsername(String username){
        Customer customer = customerRepository.findByUsername(username);
        if(customer == null)
        {
            throw new NullPointerException("Customer username not found");
        }

        return customerRepository.findByUsername(username);
    }

    public Customer getCustomerByUsernameAndPassword(String username, String password){
        Customer customer = customerRepository.findByUsernameAndPassword(username, password);
        if(customer == null)
        {
            throw new NullPointerException("Customer username and password not found");
        }

        return customerRepository.findByUsernameAndPassword(username, password);
    }

    public void deleteCustomerById(Long id) throws Exception{
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent())
        {
            throw new NullPointerException("Customer cannot be deleted. Id does not exist");
        }
        customerRepository.deleteById(id);
    }


    public Customer getCustomerByIdEquals(Long id) throws Exception{
        if(id < 1)
        {
            throw new Exception("Id cannot be less than 1");
        }
        Customer customer = customerRepository.findByIdEquals(id);
        if(customer==null)
        {
            throw new NullPointerException("Customer id not found");
        }
        return customerRepository.findByIdEquals(id);
    }
}
