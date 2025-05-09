package com.example.SchoolCrud.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SchoolCrud.Entities.Teacher;

@Service
public interface TeacherService {

	Teacher SaveTeacher(Teacher teacher);

	List<Teacher> saveAll(List<Teacher> teacher);

	List<Teacher> getAllTeacher();

	Teacher GetById(long id);

//	Object getTeacherById(int id);

	void deleteById(int id);

	void deleteAllTeacher();

	Teacher addTeacher(Teacher teacher);



}
