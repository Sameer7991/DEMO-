package com.Ecommerce.For_JPA_Project;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional

public class ProductRepo {

	@PersistenceContext 
	public EntityManager entityManager;
	public void addStudent(Product product) {
		entityManager.merge(product);
	}
	
	
}
