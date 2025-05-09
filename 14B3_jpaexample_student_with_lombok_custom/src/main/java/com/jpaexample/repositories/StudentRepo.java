package com.jpaexample.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpaexample.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepo {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	
	
	
	public void insert(Student student) {
		entityManager.merge(student);
	}
	
	
	
	
	
	
	 public List<Student> findAll() {
	        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	    }
	

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	   // Find by Name
	    public List<Student> findByName(String name) { 	
	    	
	    	
	    	
	        return entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :name", Student.class)
	        		.setParameter("name", name)
	        		.getResultList();
	    }
	
	
	    
	    
	    
	    
	
		
		   // Find by Name without case
		    public List<Student> findByNameLower(String name) {
		    	return entityManager.createQuery(
		    		    "SELECT s FROM Student s WHERE LOWER(s.name) = LOWER(:name)", Student.class)
		    		    .setParameter("name", name)
		    		    .getResultList();
		    }
		
	
	
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    // Find by Name without case
		    public List<Student> findByNameWithLike(String mehraan) {
		    	return entityManager.createQuery(
		    		    "SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(:data)", Student.class)
		    		    .setParameter("data", "%" + mehraan + "%")
		    		    .getResultList();
		    }
		    
		    
		    /*
		     "name" → The parameter name defined in WHERE s.name LIKE :name
			"%" + name + "%" → The wildcard % is added to match substrings.
		     * */
		
	    
		    
		    
		    
		    
		    
		    
		    
	
	public Student findById(long id) {
		
		
		return entityManager.find(Student.class, id);
		
		
	}
	
	
	public void deleteById(long id) {
		
		Student student = entityManager.find(Student.class, id);
		
		if(student != null) {
		entityManager.remove(student);
		System.out.println("Record Deleted");
		}
		else {
			System.out.println("Record Not Deleted!!");
			}
	
	}

}