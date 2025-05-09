package com.jpaexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexample.entities.Collage;
import com.jpaexample.entities.Student;
import com.jpaexample.repositories.CollageRepo;

@Service


public class CollageService {
	
	
	@Autowired
	private CollageRepo collageRepo;
	
	public List<Collage> getAllCollage() {
        return collageRepo.findAll();
    }
	public Optional<Collage> getCollageById(Long id) {
        return collageRepo.findById(id);
    }
	public Collage getAllCollage(Collage collage) {
        return collageRepo.save(collage);
    }
	public Collage createCollage(Collage collage) {
		return collageRepo.save(collage);
	}
	public List<Collage> createListCollage(Collage collage) {
        return collageRepo.save(null);
	}
	
	
	
	

}
