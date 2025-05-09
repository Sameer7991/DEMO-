package com.school.StuTechCrud.service;

import com.school.StuTechCrud.entity.Teacher;

import com.school.StuTechCrud.repository.TeacherRepository;

import com.school.StuTechCrud.ser.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; 

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
    private TeacherRepository teacherRepo;

    // Create
	@Override
    public Teacher save(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    // Read all
	@Override
    public List<Teacher> getAll() {
        return teacherRepo.findAll();
    }

    // Read by ID
	@Override
    public Teacher getById(int id) {
        return teacherRepo.findById(id).orElse(null);
    }

    // Update
	@Override
    public Teacher update(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    // Delete
	@Override
    public void delete(int id) {
        teacherRepo.deleteById(id);
    }
}
