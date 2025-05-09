package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Entity.Student;
import com.example.Repo.StudentRepo;

@RestController
@RequestMapping("/Students")
public class StudentController {
	
	@Autowired
	
	private StudentRepo studentRepo; // Field Injection
	
	@GetMapping("/{id}")
	public List<Student> getAllStudents() {
	    return studentRepo.FindAll(); 
	}
			
	
	 


	}
	
