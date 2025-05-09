package Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import DTO.StudentRequest;
import DTO.StudentResponse;
import Service.StudentService;
import jakarta.validation.Valid;


@RestController
//@RequestMapping
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/api")
    public StudentResponse createStudent( @RequestBody StudentRequest request) {
        return studentService.addStudent(request);
    }

    @GetMapping("/students")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }
}
