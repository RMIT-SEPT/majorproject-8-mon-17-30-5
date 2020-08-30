package com.rmit.sept.mon17305.majorproject;

import com.rmit.sept.mon17305.majorproject.model.Admin;
import com.rmit.sept.mon17305.majorproject.model.Customer;
import com.rmit.sept.mon17305.majorproject.model.ServiceObject;
import com.rmit.sept.mon17305.majorproject.model.Worker;
import com.rmit.sept.mon17305.majorproject.repository.*;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.imageio.spi.ServiceRegistry;
import java.util.Date;

@SpringBootApplication
public class MajorprojectApplication {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ServiceObjectRepository serviceObjectRepository;
    @Autowired
    private BookingRepository bookingRepository;

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
            cathy.setCompanyId((long)1);

            adminRepository.save(cathy);

            ServiceObject service = new ServiceObject();
            service.setWorkerId(john.getId());
            service.setWorkerName(john.getFirstName());
            service.setDescription("Wash outside");
            ServiceObject service1 = new ServiceObject();
            service1.setDescription("Clean inside and outside");
            service1.setWorkerName(john.getFirstName());
            service1.setWorkerId(john.getId());
            ServiceObject service2 = new ServiceObject();
            service2.setDescription("Details inside and outside");
            service2.setWorkerId(john.getId());
            service2.setWorkerName(john.getFirstName());

            serviceObjectRepository.save(service);
            serviceObjectRepository.save(service1);
            serviceObjectRepository.save(service2);



        };
    }

}
