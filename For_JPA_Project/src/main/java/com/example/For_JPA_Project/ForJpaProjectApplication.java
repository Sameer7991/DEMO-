package com.example.For_JPA_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan
@SpringBootApplication
public class ForJpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForJpaProjectApplication.class, args);
	}

}
