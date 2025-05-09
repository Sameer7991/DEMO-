package com.jpaexample.employee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create a new student with college information using Request Body
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
/**
 ResponseEntity is a class in Spring Framework that represents an HTTP response, including the status code, headers, and body. It is a powerful and flexible way to build responses in Spring MVC or Spring Boot applications, allowing you to control the HTTP response details returned to the client.

Key Features of ResponseEntity
HTTP Status Code: You can specify the HTTP status code to be returned to the client (e.g., 200 OK, 404 NOT FOUND, 201 CREATED, etc.).

Response Body: You can include any object as the response body, which will be automatically converted to the desired format (usually JSON) based on the content negotiation.

HTTP Headers: You can set custom headers in the response, which can be useful for various purposes, such as caching, content type, security, etc.
 * */
 