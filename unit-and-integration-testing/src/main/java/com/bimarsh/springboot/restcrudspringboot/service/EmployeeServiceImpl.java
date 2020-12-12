package com.bimarsh.springboot.restcrudspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bimarsh.springboot.restcrudspringboot.dao.EmployeeRepository;
import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//Use DAO to perform database operation
	private EmployeeRepository employeeRepository;
	
	//Constructor Injection
	@Autowired
	public EmployeeServiceImpl( EmployeeRepository  theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
		
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(int theId) {

		//get data without explicitly checking for null
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			//we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		employeeRepository.deleteById(theId);
	}

}
