package com.jpaexample.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeRepository collegeRepository;

    @GetMapping
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("College not found with id " + id));
    }

    @PostMapping
    public College createCollege(@RequestBody College college) {
        return collegeRepository.save(college);
    }

    
    
    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Long id, @RequestBody College collegeDetails) {
        College college = collegeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("College not found with id " + id));

        college.setName(collegeDetails.getName());
      

        return collegeRepository.save(college);
    }
    
    
    
    
    

    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable Long id) {
        College college = collegeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("College not found with id " + id));

        collegeRepository.delete(college);
        return "College deleted with id " + id;
    }
}