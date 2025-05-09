package com.jpaexample.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Accept Student object with College
    public Address createStudent(Address student) {
       
        return studentRepository.save(student);
    }
    
    
    
    
    
    
    public List<Address> getAllStudents() {
        return studentRepository.findAll();
    }

    public Address getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Additional methods as needed
}