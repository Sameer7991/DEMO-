package com.jpaexample.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
  
    @JsonManagedReference
@OneToOne(cascade = CascadeType.ALL)
  private Address address;
    
    
    
    

 

}


/*
 http://localhost:8081/colleges
 {
    "name": "asct",
    "location": "Bhopal"
}
 
 
 {
	"id":45,
    "name": "Rahul",
  "college":{
  "id":1001
    "name":"LNCT"
  }

  
 
}
 
 * */
 