package com.jpaexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaexample.entities.Student;
import com.jpaexample.repositories.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

   

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}