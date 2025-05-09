package com.example.SchoolCrud.Repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SchoolCrud.Entities.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {

}
