package com.example.SchoolCrud.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SchoolCrud.Entities.Teacher;
import com.example.SchoolCrud.Service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	

	  @Autowired
	  private TeacherService teacherService;
	  @PostMapping
	  public Teacher SaveTeacher(@RequestBody Teacher teacher) {
	      return teacherService.SaveTeacher(teacher);
	  }
	//  Get all teachers
	@GetMapping
	public ResponseEntity<List<Teacher>> getAllTeacher() {
	    return ResponseEntity.ok(teacherService.getAllTeacher());
	}

	//  Get teacher by ID 
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getTeacher(@PathVariable long id) {
	    return ResponseEntity.ok(teacherService.GetById(id));
	}
	@PostMapping("/{id}")
	public ResponseEntity<Teacher> addTeacherWithId(@PathVariable Long id, @RequestBody Teacher teacher) {
	    teacher.setId(id); // id URL se leke set kar diya
	    Teacher savedTeacher = teacherService.addTeacher(teacher);
	    return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable int id) {
		teacherService.deleteById(id);
	    return ResponseEntity.ok("Teacher deleted successfully");
	}
		
	@PostMapping("/teacher")
	public ResponseEntity<List<Teacher>> saveTeachers(@RequestBody List<Teacher> teachers) {
	    List<Teacher> saveTeachers = teacherService.saveAll(teachers);
	    return ResponseEntity.ok(saveTeachers);
	}
	@DeleteMapping("/all")
	public ResponseEntity<String> deleteAllTeacher() {
		teacherService.deleteAllTeacher();
	    return ResponseEntity.ok("All Teachers deleted successfully");
	}

	}




