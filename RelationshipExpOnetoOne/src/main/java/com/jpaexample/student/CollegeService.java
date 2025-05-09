package com.jpaexample.student;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public List<Employee> getAllColleges() {
        return collegeRepository.findAll();
    }

    public Employee addCollege(Employee college) {
        return collegeRepository.save(college);
    }
}