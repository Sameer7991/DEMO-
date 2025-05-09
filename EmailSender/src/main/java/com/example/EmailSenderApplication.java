package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller", "Service", "DTO", "Repository", "Entities"})
public class EmailSenderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmailSenderApplication.class, args);
    }
}

