package com.rmit.sept.mon17305.majorproject;

import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.repository.CustomerRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MajorprojectApplication {
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(MajorprojectApplication.class, args);
    }
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            Customer austin = new Customer();
            austin.setFirstName("Austin");
            austin.setLastName("Lay");
            austin.setBillingAddress("Address");
            austin.setShippingAddress("Address Shipping");
            austin.setUsername("Austin");

            customerRepository.save(austin);
        };
    }

}
