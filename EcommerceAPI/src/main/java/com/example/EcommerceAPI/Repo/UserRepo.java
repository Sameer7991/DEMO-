package com.example.EcommerceAPI.Repo;

import org.springframework.stereotype.Repository;

import com.example.EcommerceAPI.Entities.UserRegistration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepo {
	
	@PersistenceContext
	
	public EntityManager entityManager;
	
	
	 public void save(UserRegistration user) {
		 entityManager.merge(user);
	 }
	

}