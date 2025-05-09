package com.jpaexample.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeRepository collegeRepository;

    @GetMapping
    public List<Employee> getAllColleges() {
        return collegeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getCollegeById(@PathVariable Long id) {
        return collegeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("College not found with id " + id));
    }

    @PostMapping
    public Employee createCollege(@RequestBody Employee college) {
        return collegeRepository.save(college);
    }

    
    
    @PutMapping("/{id}")
    public Employee updateCollege(@PathVariable Long id, @RequestBody Employee collegeDetails) {
        Employee college = collegeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("College not found with id " + id));

        college.setName(collegeDetails.getName());
      

        return collegeRepository.save(college);
    }
    
    
    
    
    

    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable Long id) {
        Employee college = collegeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("College not found with id " + id));

        collegeRepository.delete(college);
        return "College deleted with id " + id;
    }
}