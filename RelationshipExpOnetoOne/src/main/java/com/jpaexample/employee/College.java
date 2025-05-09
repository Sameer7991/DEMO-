package com.jpaexample.employee;

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
public class College {
    
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
  
    
    @JsonBackReference
  @OneToOne(mappedBy = "college")   
  private Student student;
    
    
    
    
    
    

public College(String name) {
	this.name = name;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}


 

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
 