package com.example.SchoolCrud.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SchoolCrud.Entities.Student;
import com.example.SchoolCrud.Repositoty.StudentRepo;
import com.example.SchoolCrud.Service.StudentService;

import jakarta.transaction.Transactional;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Student SaveStudent(Student student) {
		return studentRepo.save(student);	
	}
	@Override
	public List<Student> saveAll(List<Student> students) {
		return studentRepo.saveAll(students);
	}
	@Override
	   public List<Student> getAllStudent(){
	   return studentRepo.findAll();
	   }
	 public Student getStudentById(long id) {
	        return studentRepo.findById(id).orElse(null);
	    }
	   @Override
	   public Student GetById(long id) {
	       return studentRepo.findById(id).orElse(null);
	   }
	   @Transactional
	   public void deleteById(long id) {
		    studentRepo.deleteById(id);
		}
	   @Transactional
	    public void deleteAllStudents() {
	        studentRepo.deleteAll();
	    }
	   public Student addStudent(Student student) {
		    return studentRepo.save(student);
		}

	   }
