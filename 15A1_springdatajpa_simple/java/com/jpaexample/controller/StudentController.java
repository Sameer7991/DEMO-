package com.jpaexample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpaexample.entities.Student;
import com.jpaexample.service.StudentService;

/*
@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping
    public Optional<List<Student>> getAllStudent(){
    	return Optional.ofNullable(studentService.getAllStudents());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}
        }
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  /*  @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }
    
    @GetMapping("/name/withoutcase/{name}")
    public List<Student> getStudentsWithoutCase(@PathVariable String name) {
        return studentService.getStudentsWithoutCase(name);
    }
    
    @GetMapping("/search/{data}")
    public List<Student> searchStudent(@PathVariable String data) {
        return studentService.searchStudent(data);
    }*/
    
    
    
    /*
    
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
       studentService.deleteStudent(id);
       return "Delete Record Successfully";
    }
    
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  /* @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student savedStudent = studentService.updateStudent(id, updatedStudent);
        if (savedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(savedStudent);
    }
}


*/



	  
	  /*
	   @GetMapping("/{id}")
public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    return studentRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}
	   */



/*
  private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    
    GET 
   http://localhost:8080/students/1
   
   http://localhost:8080/students
    
    http://localhost:8080/students/name/Mark
    http://localhost:8080/students/name/withoutcase/mARk
    http://localhost:8080/students/search/John
    
    POST http://localhost:8080/students
    Content-Type: application/json
    {
    "id": 5,
    "name": "Rohan",
    "college": "ASCT"
}


PUT http://localhost:8080/students/5
Content-Type: application/json
{
    "name": "Rahul",
    "college": "RGPV"
}

    DELETE http://localhost:8080/students/5

    
 * */
 