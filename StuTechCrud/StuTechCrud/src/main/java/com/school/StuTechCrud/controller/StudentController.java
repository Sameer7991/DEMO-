package com.school.StuTechCrud.controller;

import com.school.StuTechCrud.entity.Student;
import com.school.StuTechCrud.ser.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //  Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    //  Get student by ID 
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    //  Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        return ResponseEntity.ok(studentService.update(student));
    }

    //  Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }

    //  Get students by course
    @GetMapping("/course/{course}")
    public ResponseEntity<List<Student>> getByCourse(@PathVariable String course) {
        return ResponseEntity.ok(studentService.getByCourse(course));
    }

    //  Get students by teacher ID
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Student>> getByTeacher(@PathVariable int teacherId) {
        return ResponseEntity.ok(studentService.getByTeacherId(teacherId));
    }
}
