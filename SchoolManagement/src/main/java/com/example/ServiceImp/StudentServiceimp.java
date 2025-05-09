package com.example.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entities.Student;
import com.example.Repository.StudentRepo;
import com.example.Service.StudentService;


@Service
public class StudentServiceimp implements StudentService {
	
   @Autowired
	private StudentRepo studentRepo;
   
   @Override
   public Student save(Student student) {
	   return studentRepo.save(student);
   }
   @Override
   public List<Student> getAllStudent(){
   return studentRepo.findAll();
   }
   @Override
   public Student GetById(long id) {
       return studentRepo.findById(id).orElse(null);
   }
   @Override
   public Student DeleteById(long id){
	    studentRepo.deleteById(id);
		return null;
  }
   
   
   
   
}
   
   
   
   
   
