package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	@Id
	@Column(name = "Student_id")
	long Id;
	@Column(name = "Student_Name")
	String Name;
	@Column(name = "Student_Enrollment")
	int Enollment;
}
