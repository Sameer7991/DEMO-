package com.school.StuTechCrud.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id 
	private int id;
	
	private String name;
	private String email;
	private String enrollmentDate;
	private String course;
	
	@ManyToOne
    @JoinColumn(name = "teacher_id") // foreign key column in Student table
    private Teacher teacher;
}
