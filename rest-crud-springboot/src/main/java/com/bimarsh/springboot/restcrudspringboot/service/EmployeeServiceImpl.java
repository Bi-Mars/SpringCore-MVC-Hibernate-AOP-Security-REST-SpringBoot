package com.bimarsh.springboot.restcrudspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bimarsh.springboot.restcrudspringboot.dao.EmployeeDAO;
import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//Use DAO to perform database operation
	private EmployeeDAO employeeDAO;
	
	//Constructor Injection
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO  theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
		
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeDAO.getAllEmployee();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int theId) {

		return employeeDAO.findByEmployeeId(theId);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		
		employeeDAO.saveEmployee(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		employeeDAO.deleteEmployee(theId);
	}

}
