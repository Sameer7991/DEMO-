package com.school.StuTechCrud.repository;

import com.school.StuTechCrud.entity.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
