package com.bimarsh.springboot.restcrudspringboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bimarsh.springboot.restcrudspringboot.dao.EmployeeDAO;
import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	//Use DAO to perform database operation
	private EmployeeDAO employeeDAO;
	
	//Constructor Injection
	@Autowired
	public EmployeeRestController(EmployeeDAO  theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
		
	}
	
	//expose "/employee" and return list of employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		
		return employeeDAO.getAllEmployee();
	}
}
