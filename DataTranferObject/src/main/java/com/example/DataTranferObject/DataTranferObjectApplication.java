package com.example.DataTranferObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "Entities")  // 👈 Ye line add kar!

public class DataTranferObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataTranferObjectApplication.class, args);
	}

}
