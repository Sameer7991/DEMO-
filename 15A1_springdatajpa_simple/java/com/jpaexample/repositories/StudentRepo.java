package com.jpaexample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jpaexample.entities.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
  
}