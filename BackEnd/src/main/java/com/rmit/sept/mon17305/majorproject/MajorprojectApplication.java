package com.rmit.sept.mon17305.majorproject;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.repository.AdminRepository;
import com.rmit.sept.mon17305.majorproject.repository.CustomerRepository;
import com.rmit.sept.mon17305.majorproject.repository.WorkerRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class MajorprojectApplication {
    @Autowired
    private CustomerRepository customerRepository;
    private WorkerRepository workerRepository;
    private AdminRepository adminRepository;

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
            austin.setPassword("Lay");

            customerRepository.save(austin);

            Worker john = new Worker();
            john.setFirstName("John");
            john.setLastName("Serta");
            john.setUsername("John");
            john.setPassword("1234");
            john.setStartTime(new Date());
            john.setFinishTime(new Date());
            john.setWorkingDays("Mon/Wed/Fri");

            workerRepository.save(john);

            Admin cathy = new Admin();
            cathy.setFirstName("Cathy");
            cathy.setLastName("Ropkhop");
            cathy.setUsername("cathy");
            cathy.setPassword("1234");

            adminRepository.save(cathy);

        };
    }

}
