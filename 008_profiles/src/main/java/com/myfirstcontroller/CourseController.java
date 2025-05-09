package com.myfirstcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return Arrays.asList(
				new Course(1,"Java","abc"),
				new Course(2,"Angular","xyz"),
				new Course(3,"Flutter","ijk")
				
				);
	}
	
}
