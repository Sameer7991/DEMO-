package com.jpaexample.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Student {
	
	@Id
	private long id;
	

	private String name;
	
		
	private String college;

	public Student() {

	}

	public Student(long id, String name, String college) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCollege() {
		return college;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", college=" + college + "]";
	}

	// constructor
	// getters
	// toString

}