package com.example.DTOProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;
	private String email;
	private String  password ;
	private String age ;
	
	
	private String role ;//default 

	
	

}
