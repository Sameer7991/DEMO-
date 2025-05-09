package com.example.SchoolCrud.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SchoolCrud.Entities.Student;

@Service
public interface StudentService {

	Student SaveStudent(Student student);

	List<Student> getAllStudent();

	Student GetById(long id);

	
	List<Student> saveAll(List<Student> students);

	void deleteById(long id);

//	Object getStudentById(long id);

	void deleteAllStudents();


}
