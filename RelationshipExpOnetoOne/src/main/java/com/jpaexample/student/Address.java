package com.jpaexample.student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
 
    private Long id;
    private String city;
    private String state;

   @JsonBackReference
    @OneToOne(mappedBy = "address")
    private Employee employee;

    
    
    
    
    






	

	

    
    
}


/*
 {
    "name": "Rohan",
  "college": {
    "name" : "RGPV",
    "location": "Bhopal"
  }
 
}
 
 * */
 