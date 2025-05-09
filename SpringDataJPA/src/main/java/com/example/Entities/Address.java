package com.example.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Address {

	@Id
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	long id;
	String Address;
	
	
	
	@JsonBackReference
	@OneToOne(mappedBy = "Address")
	private Address address;
	
}
