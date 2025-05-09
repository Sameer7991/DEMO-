package com.example.Repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepo {
	
	@PersistenceContext
	
	private EntityManager entityManager ;
	
	public Student insert(Student student) {
		return entityManager.merge(student);
	}
	
	public List<Student> FindAll(){
		return entityManager.createQuery("SELECT s FROM Student s",Student.class).getResultList();
	}	
	
	
	
	
	}

