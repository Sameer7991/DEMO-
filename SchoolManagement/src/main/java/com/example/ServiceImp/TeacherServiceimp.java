package com.example.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entities.Teacher;
import com.example.Repository.TeacherRepo;
import com.example.Service.TeacherService;


@Service
public class TeacherServiceimp implements TeacherService {
	
	@Autowired
	private TeacherRepo teacherRepo ;
	
	@Override
	public Teacher save(Teacher teacher) {
	   return teacherRepo.save(teacher);
   }
//	@Override
//   public List<Teacher> getAllTeacher(){
//   return teacherRepo.findAll();
//   }
//   @Override
//   public Teacher GetById(int id) {
//       return teacherRepo.findById(id).orElse(null);
//   }
//   @Override
//   public Teacher DeleteById(int id){
//	    teacherRepo.deleteById(id);
//		return null;
//	    
//  }

}
