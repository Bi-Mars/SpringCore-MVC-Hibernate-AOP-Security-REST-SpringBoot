package com.bimarsh.springboot.restcrudspringboot.dao;

import java.util.List;

import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployee();
}
