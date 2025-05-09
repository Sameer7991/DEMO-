package com.example.Standardized.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Standardized.API.Repository")
@EntityScan(basePackages = "com.example.Standardized.API.Entities")
public class StandardizedApiResponseApplication {

    public static void main(String[] args) {
        SpringApplication.run(StandardizedApiResponseApplication.class, args);
    }
}
