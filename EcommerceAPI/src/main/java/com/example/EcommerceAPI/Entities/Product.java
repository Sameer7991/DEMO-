package com.example.EcommerceAPI.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {
	@Id
	long id;
	String name;
	String description;
	double price;
	int quantity;
	
	

}
