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

import com.example.SchoolCrud.Entities.Student;
import com.example.SchoolCrud.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentService studentService;
  @PostMapping
  public Student SaveStudent(@RequestBody Student student) {
      return studentService.SaveStudent(student);
  }
//  Get all students
@GetMapping
public ResponseEntity<List<Student>> getAllStudents() {
    return ResponseEntity.ok(studentService.getAllStudent());
}

//  Get student by ID 
@GetMapping("/{id}")
public ResponseEntity<Student> getStudent(@PathVariable long id) {
    return ResponseEntity.ok(studentService.GetById(id));
}
@PostMapping("/{id}")
public ResponseEntity<Student> addStudentWithId(@PathVariable Long id, @RequestBody Student student) {
	student.setId(id); // id URL se leke set kar diya
    Student savedStudent = studentService.SaveStudent(student);
    return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable int id) {
    studentService.deleteById(id);
    return ResponseEntity.ok("Student deleted successfully");
}
	
@PostMapping("/student")
public ResponseEntity<List<Student>> saveStudents(@RequestBody List<Student> students) {
    List<Student> savedStudents = studentService.saveAll(students);
    return ResponseEntity.ok(savedStudents);
}
@DeleteMapping("/all")
public ResponseEntity<String> deleteAllStudents() {
    studentService.deleteAllStudents();
    return ResponseEntity.ok("All students deleted successfully");
}

}
