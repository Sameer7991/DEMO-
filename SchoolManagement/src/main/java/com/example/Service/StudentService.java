package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entities.Student;

@Service
public interface StudentService {

	Student save(Student student);

	List<Student> getAllStudent();
	
	Student GetById(long id);

	Student DeleteById(long id);


}
