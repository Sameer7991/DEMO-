package com.jpaexample.runner;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpaexample.entities.Books;
import com.jpaexample.entities.Product;
import com.jpaexample.entities.Student;
import com.jpaexample.repositories.BookRepo;
import com.jpaexample.repositories.ProductRepo;
import com.jpaexample.repositories.StudentRepo;

@Component
public class MyRunner implements CommandLineRunner{


	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	

	public void run(String... args) throws Exception {
		
/*		bookRepo.insert(new Books(123,"Java","TMH"));
		bookRepo.insert(new Books(124,"Python","TMH"));
		productRepo.insert(new Product(524,"shdjkfs","4568"));*/
		
		Student s = new Student();
		s.setId(123);
		s.setName("Rohan");
		s.setCollege("LNCT");
		
		
		studentRepo.insert(s);
		
		
	/*Student getData = studentRepo.findById(2);*/
		
		
		
	
		System.out.println(studentRepo.findById(123));
		
		

		
	}

}