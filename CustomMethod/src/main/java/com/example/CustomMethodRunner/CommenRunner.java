package com.example.CustomMethodRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.CustomMethodEntities.Student;
import com.example.CustomMethodRepos.StudentRepo;

public class CommenRunner implements CommandLineRunner {

	@Autowired 
	public StudentRepo studentRepo ;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		studentRepo.insert(new Student(1,"Mark","ASCT"));
		studentRepo.insert(new Student(2,"Basheer Bhai","MANIT"));
		studentRepo.insert(new Student(3,"DEF","RGPV"));
		
	                                  // TODO Auto-generated method stub


	}

}
