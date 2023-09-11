package com.example.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages={"com.example.demo"})
@EntityScan(basePackages = {"com.example.demo.utilities.repository"})
@EnableJpaRepositories(basePackages = {"com.example.demo.utilities.repository"})
public class DemoApplication {

    public static void main(String[] args) {
        String version = DemoApplication.class.getPackage().getImplementationVersion();
        System.out.printf("***************** Spring demo start %s *******************%n", version != null ? version : "(not packaged)");
        SpringApplication.run(DemoApplication.class, args);
    }


}
