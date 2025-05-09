package com.jpaexample.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner{


	@Autowired
	private StudentRepo repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		Student s = new Student();
		
		s.setId(12);
		s.setName("Mark");
		s.setCollege("RGPV");
		
		Student s1 = new Student();		
		s1.setId(13);
		s1.setName("John");
		s1.setCollege(s.getCollege()); //Rgpv
		
		
		

		repository.insert(s);
		repository.insert(s1);

		
	}

}