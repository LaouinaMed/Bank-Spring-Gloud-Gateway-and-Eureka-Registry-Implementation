package com.example.customerservice;

import com.example.customerservice.config.GlobalConfig;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList = List.of(

                    Customer.builder()
                            .firstName("Med")
                            .lastName("Laouina")
                            .email("Med@gmail.com")
                            .build(),

                    Customer.builder()
                            .firstName("Yassin")
                            .lastName("LHB")
                            .email("Yasssin@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }

}
