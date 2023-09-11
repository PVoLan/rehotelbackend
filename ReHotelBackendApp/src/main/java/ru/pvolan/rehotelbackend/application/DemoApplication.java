package ru.pvolan.rehotelbackend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"ru.pvolan.rehotelbackend"})
@EntityScan(basePackages = {"ru.pvolan.rehotelbackend.utilities.repository"})
@EnableJpaRepositories(basePackages = {"ru.pvolan.rehotelbackend.utilities.repository"})
public class DemoApplication {

    public static void main(String[] args) {
        String version = DemoApplication.class.getPackage().getImplementationVersion();
        System.out.printf("***************** Spring demo start %s *******************%n", version != null ? version : "(not packaged)");
        SpringApplication.run(DemoApplication.class, args);
    }


}
