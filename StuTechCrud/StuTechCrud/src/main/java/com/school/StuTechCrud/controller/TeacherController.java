package com.school.StuTechCrud.controller;

import com.school.StuTechCrud.entity.Student;


import com.school.StuTechCrud.entity.Teacher;

import com.school.StuTechCrud.ser.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //  Create a new teacher
    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    //  Get all teachers
    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    //  Get teacher by ID
    @GetMapping("/{id}")
    public Teacher getById(@PathVariable int id) {
        return teacherService.getById(id);
    }

    //  Update teacher
    @PutMapping
    public Teacher update(@RequestBody Teacher teacher) {
        return teacherService.update(teacher);
    }

    // Delete teacher by ID
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        teacherService.delete(id);
        return "Deleted teacher with ID: " + id;
    }
    
    // Get Student under a teacher
    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getStudentsOfTeacher(@PathVariable int id) {
        Teacher teacher = teacherService.getById(id);
        return ResponseEntity.ok(teacher.getStudents());
    }

    
    
    
    
    
}
