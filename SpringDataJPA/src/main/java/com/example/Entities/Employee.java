package com.example.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Employee {

	@Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	long id;
	String name;
	String collage;
    
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

}

