package com.jpaexample.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Collage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
	long id;
	String Name;
	
}
