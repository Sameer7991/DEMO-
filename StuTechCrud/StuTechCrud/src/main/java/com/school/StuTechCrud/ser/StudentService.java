package com.school.StuTechCrud.ser;

import com.school.StuTechCrud.entity.Student;

import java.util.List;

public interface StudentService {

	Student save(Student student);
 
	List<Student> getAll();

	Student getById(int id);

	List<Student> getByTeacherId(int teacherId);

	List<Student> getByCourse(String course);

	void delete(int id);

	Student update(Student student);
	
	
} 
