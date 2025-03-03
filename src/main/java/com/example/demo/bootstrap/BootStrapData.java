package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Division division = divisionRepository.getReferenceById(2L);

        if (customerRepository.count() == 0 ) {
            Customer customer1 = new Customer();
            customer1.setFirstName("bob");
            customer1.setLastName("jangles");
            customer1.setAddress("2134 Oak");
            customer1.setPostal_code("11111");
            customer1.setPhone("1111111111");
            customer1.setDivision(division);
            customerRepository.save(customer1);

            Customer customer2 = new Customer();
            customer2.setFirstName("jeff");
            customer2.setLastName("jones");
            customer2.setAddress("9514 Hill");
            customer2.setPostal_code("22222");
            customer2.setPhone("2222222222");
            customer2.setDivision(division);
            customerRepository.save(customer2);

            Customer customer3 = new Customer();
            customer3.setFirstName("mary");
            customer3.setLastName("lamb");
            customer3.setAddress("9875 Farm");
            customer3.setPostal_code("33333");
            customer3.setPhone("3333333333");
            customer3.setDivision(division);
            customerRepository.save(customer3);

            Customer customer4 = new Customer();
            customer4.setFirstName("marge");
            customer4.setLastName("simpson");
            customer4.setAddress("2134 Spring");
            customer4.setPostal_code("44444");
            customer4.setPhone("44444444444");
            customer4.setDivision(division);
            customerRepository.save(customer4);

            Customer customer5 = new Customer();
            customer5.setFirstName("bill");
            customer5.setLastName("bo");
            customer5.setAddress("124 north");
            customer5.setPostal_code("55555");
            customer5.setPhone("55555555555");
            customer5.setDivision(division);
            customerRepository.save(customer5);
    }
    }
}
