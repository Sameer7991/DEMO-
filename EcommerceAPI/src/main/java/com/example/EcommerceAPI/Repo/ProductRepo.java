package com.example.EcommerceAPI.Repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.EcommerceAPI.Entities.Product;

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
	public List<Product> findAll() { 
		return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	}
	
}
