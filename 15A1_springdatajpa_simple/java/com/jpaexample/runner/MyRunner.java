package com.jpaexample.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpaexample.entities.Books;
import com.jpaexample.entities.Collage;
import com.jpaexample.entities.Product;
import com.jpaexample.entities.Student;
import com.jpaexample.repositories.BookRepo;
import com.jpaexample.repositories.CollageRepo;
import com.jpaexample.repositories.ProductRepo;
import com.jpaexample.repositories.StudentRepo;
import com.jpaexample.service.CollageService;

@Component
public class MyRunner implements CommandLineRunner{



	
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private CollageRepo collageRepo;
	

	

	public void run(String... args) throws Exception {
		
/*		bookRepo.insert(new Books(123,"Java","TMH"));
		bookRepo.insert(new Books(124,"Python","TMH"));
		productRepo.insert(new Product(524,"shdjkfs","4568"));*/
		
		studentRepo.save(new Student(1,"Mark","ASCT"));
		studentRepo.save(new Student(2,"Basheer Bhai","MANIT"));
		studentRepo.save(new Student(3,"DEF","RGPV"));
		
		collageRepo.save(new Collage(1, "ACT"));
		collageRepo.save(new Collage(2, "MCT"));
		collageRepo.save(new Collage(3, "RGPV"));
		
		
		

				
	
		
	}

}