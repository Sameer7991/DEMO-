package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entities.Employee;
import com.example.Repository.EmployeeRepo;
import com.example.Runner.StudentService;

@Service 

public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee createEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}
	
	public List<Employee> GetAllEmployee(){
		return employeeRepo.findAll(); 
	}
	
	
	
}
