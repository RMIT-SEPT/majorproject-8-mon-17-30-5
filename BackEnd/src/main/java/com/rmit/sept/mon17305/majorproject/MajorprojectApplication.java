package com.rmit.sept.mon17305.majorproject;

import com.rmit.sept.mon17305.majorproject.model.*;
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
    @Autowired
    private CompanyRepository companyRepository;

    public static void main(String[] args) {
        SpringApplication.run(MajorprojectApplication.class, args);
    }
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            Customer austin = new Customer();
            austin.setFirstName("Austin");
            austin.setLastName("Lay");
            austin.setBillingAddress("Austin Billing Address");
            austin.setShippingAddress("Austin Shipping Address");
            austin.setUsername("Austin");
            austin.setPassword("Lay");
            austin.setPhone("0401444787");

            customerRepository.save(austin);

            Customer ben = new Customer();
            ben.setFirstName("Ben");
            ben.setLastName("Hankins");
            ben.setBillingAddress("Ben Billing Address");
            ben.setShippingAddress("Ben Shipping Address");
            ben.setUsername("Ben");
            ben.setPassword("password");
            ben.setPhone("0401444665");
            customerRepository.save(ben);

            Company business1 = new Company();
            business1.setId((long)1);
            business1.setCompanyName("Tim Car Wash");
            companyRepository.save(business1);

            Worker john = new Worker();
            john.setFirstName("John");
            john.setLastName("Serta");
            john.setUsername("John");
            john.setPassword("1111");
            john.setStartTime("08:00");
            john.setFinishTime("16:00");
            john.setLunchBrTime("11:00");
            john.setCompanyId(business1.getId());
            john.setPhone("0488456777");

            workerRepository.save(john);

            Worker minta = new Worker();
            minta.setFirstName("Minata");
            minta.setLastName("Serta");
            minta.setUsername("Mina");
            minta.setPassword("1111");
            minta.setStartTime("09:00");
            minta.setFinishTime("17:00");
            minta.setLunchBrTime("12:00");
            minta.setCompanyId(business1.getId());
            minta.setPhone("0411232232");

            workerRepository.save(minta);

            Admin cathy = new Admin();
            cathy.setFirstName("Cathy");
            cathy.setLastName("Ropkhop");
            cathy.setUsername("cathy");
            cathy.setPassword("1111");
            cathy.setCompanyId(business1.getId());
            cathy.setPhone("0490123456");

            adminRepository.save(cathy);

            ServiceObject service = new ServiceObject();
            service.setDescription("Wash outside");
            service.setDuration(1);
            service.setCompanyId(business1.getId());
            ServiceObject service1 = new ServiceObject();
            service1.setDescription("Clean inside and outside");
            service1.setDuration(2);
            service1.setCompanyId(business1.getId());
            ServiceObject service2 = new ServiceObject();
            service2.setDescription("Details inside and outside");
            service2.setDuration(2);
            service2.setCompanyId(business1.getId());

            serviceObjectRepository.save(service);
            serviceObjectRepository.save(service1);
            serviceObjectRepository.save(service2);


            Company business2 = new Company();
            business2.setId((long)2);
            business2.setCompanyName("Sandy Hair Dressor");
            companyRepository.save(business2);

            Worker winnie = new Worker();
            winnie.setFirstName("Winnie");
            winnie.setLastName("Yuenyon");
            winnie.setUsername("Winnie");
            winnie.setPassword("2222");
            winnie.setStartTime("09:00");
            winnie.setFinishTime("17:00");
            winnie.setLunchBrTime("12:00");
            winnie.setCompanyId(business2.getId());
            winnie.setPhone("0444479797");

            workerRepository.save(winnie);

            Worker mack = new Worker();
            mack.setFirstName("Mack");
            mack.setLastName("MackerMc");
            mack.setUsername("Mack");
            mack.setPassword("2222");
            mack.setStartTime("08:00");
            mack.setFinishTime("16:00");
            mack.setLunchBrTime("11:00");
            mack.setCompanyId(business2.getId());
            mack.setPhone("0488456000");

            workerRepository.save(mack);

            ServiceObject hairCut = new ServiceObject();
            hairCut.setCompanyId(business2.getId());
            hairCut.setDuration(1);
            hairCut.setDescription("Hair Cut");

            ServiceObject hairWash = new ServiceObject();
            hairWash.setDescription("Hair Wash");
            hairWash.setDuration(1);
            hairWash.setCompanyId(business2.getId());

            ServiceObject colour = new ServiceObject();
            colour.setCompanyId(business2.getId());
            colour.setDuration(3);
            colour.setDescription("Hair Colour");

            serviceObjectRepository.save(hairCut);
            serviceObjectRepository.save(hairWash);
            serviceObjectRepository.save(colour);

            Admin nic = new Admin();
            nic.setFirstName("Nicky");
            nic.setLastName("Chan");
            nic.setUsername("Nic");
            nic.setPassword("2222");
            nic.setCompanyId(business2.getId());
            nic.setPhone("0488000888");

            adminRepository.save(nic);
        };
    }

}
