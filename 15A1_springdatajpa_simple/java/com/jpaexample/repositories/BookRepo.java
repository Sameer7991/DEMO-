package com.jpaexample.repositories;

import org.springframework.stereotype.Repository;

import com.jpaexample.entities.Books;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookRepo {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	
	
	
	public void insert(Books book) {
		entityManager.merge(book);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}