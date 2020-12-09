package com.bimarsh.springboot.restcrudspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//that's it ... no need to write any code
}
