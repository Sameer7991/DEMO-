package com.jpaexample.repositories;

import org.springframework.stereotype.Repository;

import com.jpaexample.entities.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductRepo {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	
	
	
	public void insert(Product product) {
		entityManager.merge(product);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}