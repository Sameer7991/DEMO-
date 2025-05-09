package com.school.StuTechCrud.ser;

import com.school.StuTechCrud.entity.Teacher;

import org.springframework.stereotype.Service;

import java.util.List; 

@Service
public interface TeacherService {

	Teacher save(Teacher teacher);

	List<Teacher> getAll();

	Teacher getById(int id);

	Teacher update(Teacher teacher);

	void delete(int id);

	
}
