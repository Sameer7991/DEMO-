package com.school.StuTechCrud.service;

import com.school.StuTechCrud.entity.Student;
import com.school.StuTechCrud.repository.StudentRepository;
import com.school.StuTechCrud.ser.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	// Create Student
	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}
	
	// Get All Students
	@Override
	public List<Student> getAll(){
		return studentRepo.findAll();
	}
	
	//Get Student By Id
	@Override
	public Student getById(int id) {
	 	return studentRepo.findById(id).orElse(null);
	}
	
	// Update Student
	@Override
	public Student update(Student student) {
		return studentRepo.save(student); 
	}
	
	// Delete Student by Id
	@Override
	public void delete(int id) {
		studentRepo.deleteById(id); 
	}
	
	// Get Students by course
	@Override
	public List<Student> getByCourse(String course){
		return studentRepo.findByCourse(course);
	}
	
	// Get Students by Teachers Id
	@Override
	public List<Student> getByTeacherId(int teacherId) {
		
		return studentRepo.findByTeacherId(teacherId);
	}
	
	
	
	
	
	
	
	
	
	
	
} 
