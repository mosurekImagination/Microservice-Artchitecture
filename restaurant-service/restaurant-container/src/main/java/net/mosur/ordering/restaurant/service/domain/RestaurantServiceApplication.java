package net.mosur.ordering.restaurant.service.domain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "net.mosur.ordering.restaurant.service.dataaccess", "net.mosur.ordering.dataaccess" })
@EntityScan(basePackages = { "net.mosur.ordering.restaurant.service.dataaccess", "net.mosur.ordering.dataaccess" })
@SpringBootApplication(scanBasePackages = "net.mosur.ordering")
public class RestaurantServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }
}
