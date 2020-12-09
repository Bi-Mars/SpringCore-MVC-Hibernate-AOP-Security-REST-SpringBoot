package com.bimarsh.springboot.restcrudspringboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bimarsh.springboot.restcrudspringboot.entity.Employee;
import com.bimarsh.springboot.restcrudspringboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//Use DAO to perform database operation
	private EmployeeService employeeService;
	
	//Constructor Injection
	@Autowired
	public EmployeeRestController(EmployeeService  theEmployeeService) {
		employeeService = theEmployeeService;
		
	}
	
	//expose "/employee" and return list of employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		
		return employeeService.findAll();
	}
	
	//	expose "/employee/{theId}" and return employee of given Id
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findEmployeeById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	//	expose POST "/employees" add new employee

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0); // insert overation on saveOrUpdate
		employeeService.saveEmployee(employee);
		
		return employee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return employee;
			
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findEmployeeById(employeeId);
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found- " + employeeId);
		}
		employeeService.deleteEmployee(employeeId);
		
		return "Deleted employye id " + employeeId;

	}
	

}
