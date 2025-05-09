package com.example.CustomMethodRepos;

import org.springframework.stereotype.Repository;

import com.example.CustomMethodEntities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepo {
    
	@PersistenceContext
	
	private EntityManager entityManager;
	
	public  void insert(Student student){
	entityManager.merge(student);
	
      /*public Student findById(long id){
		return entityManager.find(Student.class,id);
	}*/
	
	}
}
