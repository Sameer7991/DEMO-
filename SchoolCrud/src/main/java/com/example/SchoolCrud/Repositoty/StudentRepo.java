package com.example.SchoolCrud.Repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SchoolCrud.Entities.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
