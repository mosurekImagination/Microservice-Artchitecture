package net.mosur.food.ordering.system.customer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = { "net.mosur.food.ordering.system.customer.service.dataaccess", "net.mosur.food.ordering.system.dataaccess"})
@EntityScan(basePackages = { "net.mosur.food.ordering.system.customer.service.dataaccess", "net.mosur.food.ordering.system.dataaccess" })
@SpringBootApplication(scanBasePackages = "net.mosur.food.ordering.system")
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
