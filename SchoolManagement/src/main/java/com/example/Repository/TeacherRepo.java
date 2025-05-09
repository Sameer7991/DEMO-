package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entities.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long> {

}
