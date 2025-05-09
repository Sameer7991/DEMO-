package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entities.Employee;
import com.example.Service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee createEmployee = employeeService.createEmployee(employee);
	   return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);

	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> GetAllEmployee(@RequestBody Employee employee){
		List<Employee> Employee= employeeService.GetAllEmployee();
		return new ResponseEntity<>(Employee, HttpStatus.OK);
	}
	
	
	
	
	
}
