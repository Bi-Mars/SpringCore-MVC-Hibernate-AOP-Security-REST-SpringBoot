package com.bimarsh.springboot.restcrudspringboot.service;

import java.util.List;

import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findEmployeeById(int theId);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleteEmployee(int theId);

}
