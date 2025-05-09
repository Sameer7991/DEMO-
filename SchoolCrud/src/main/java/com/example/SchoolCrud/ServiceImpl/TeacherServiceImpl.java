package com.example.SchoolCrud.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SchoolCrud.Entities.Teacher;
import com.example.SchoolCrud.Repositoty.TeacherRepo;
import com.example.SchoolCrud.Service.TeacherService;

import jakarta.transaction.Transactional;
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepo teacherRepo;
	
	@Override
	public Teacher SaveTeacher(Teacher teacher) {
		return teacherRepo.save(teacher);	
	}
	@Override
	public List<Teacher> saveAll(List<Teacher> teacher) {
		return teacherRepo.saveAll(teacher);
	}
	@Override
	   public List<Teacher> getAllTeacher(){
	   return teacherRepo.findAll();
	   }
	 public Teacher getTeacherById(long id) {
	        return teacherRepo.findById(id).orElse(null);
	    }
	   @Override
	   public Teacher GetById(long id) {
	       return teacherRepo.findById(id).orElse(null);
	   }
	   @Transactional
	   public void deleteById(long id) {
		   teacherRepo.deleteById(id);
		}
	   @Transactional
	    public void deleteAllTeachers() {
		   teacherRepo.deleteAll();
	    }
	   public Teacher addTeacher(Teacher teacher) {
		    return teacherRepo.save(teacher);
		}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllTeacher() {
		// TODO Auto-generated method stub
		
	}
	   }
