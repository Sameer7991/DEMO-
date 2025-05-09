package com.jpaexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaexample.entities.Collage;

@Repository
public interface CollageRepo extends JpaRepository<Collage,Long> {

}
