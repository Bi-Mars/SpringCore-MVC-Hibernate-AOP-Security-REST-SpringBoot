package com.bimarsh.springboot.restcrudspringboot.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bimarsh.springboot.restcrudspringboot.dao.EmployeeRepository;
import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// Use DAO to perform database operation
	private EmployeeRepository employeeRepository;

	// Constructor Injection
	@Autowired
	public EmployeeRestController(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;

	}

	// expose "/employee" and return list of employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}

	// expose "/employee/{theId}" and return employee of given Id

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {

		// get data without explicitly checking for null
		Optional<Employee> result = employeeRepository.findById(employeeId);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + employeeId);
		}
		return theEmployee;
	}

	// expose POST "/employees" add new employee

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {

		employee.setId(0); // insert overation on saveOrUpdate
		employeeRepository.save(employee);

		return employee;

	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		employeeRepository.save(employee);

		return employee;

	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		// get data without explicitly checking for null
		Optional<Employee> result = employeeRepository.findById(employeeId);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + employeeId);
		}

		employeeRepository.deleteById(employeeId);
		return "Deleted employye id " + employeeId;

	}

}
