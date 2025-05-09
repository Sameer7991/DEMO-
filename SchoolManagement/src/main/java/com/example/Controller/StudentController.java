package com.example.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entities.Student;
import com.example.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
    private StudentService studentService;

    //  Create a student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

//    //  Get all students
//    @GetMapping
//    public ResponseEntity<List<Student>> getAllStudents() {
//        return ResponseEntity.ok(studentService.getAllStudent());
//    }
//
//    //  Get student by ID 
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudent(@PathVariable int id) {
//        return ResponseEntity.ok(studentService.GetById(id));
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Student> DeleteStudent(@PathVariable int id) {
//		return null;
//    	
//    }
}

   