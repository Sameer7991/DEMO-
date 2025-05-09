package com.school.StuTechCrud.repository;

import com.school.StuTechCrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	  List<Student> findByCourse(String course);
	    List<Student> findByTeacherId(int teacherId); 
	
}
