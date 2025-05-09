package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entities.Teacher;
import com.example.Service.TeacherService;

@RestController
@RequestMapping("/teacher")

public class TeacherController {

	@Autowired
    private TeacherService teacherService;

    //  Create a student
	@PostMapping("/create")
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

//    //  Get all students
//    @GetMapping
//    public ResponseEntity<List<Teacher>> getAllTeachers() {
//        return ResponseEntity.ok(teacherService.getAllTeacher());
//    }
//
//    //  Get student by ID 
//    @GetMapping("/{id}")
//    public ResponseEntity<Teacher> getTeacher(@PathVariable int id) {
//        return ResponseEntity.ok(teacherService.GetById(id));
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Teacher> DeleteTeacher(@PathVariable int id) {
//		return null;
//    	
//    }

}
