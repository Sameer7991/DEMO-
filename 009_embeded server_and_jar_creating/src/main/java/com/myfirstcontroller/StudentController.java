package com.myfirstcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return Arrays.asList(
				
				new Student(1,"John","1001"),
				new Student(2,"John","1002"),
				new Student(3,"abc","1003"),
				new Student(4,"def","1004")
					
				);
	}
	
	
	
	
	
}
