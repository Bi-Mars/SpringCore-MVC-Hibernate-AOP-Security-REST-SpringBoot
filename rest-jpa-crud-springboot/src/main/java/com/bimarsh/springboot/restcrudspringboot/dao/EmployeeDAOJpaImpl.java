package com.bimarsh.springboot.restcrudspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	//define a field for EntityManager
	private EntityManager entityManager;
	
	//constructor Injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;		
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		
		//create a query 
		Query theQuery =
				entityManager.createQuery("from Employee ");
		
		//execute a query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findByEmployeeId(int theId) {

		return null;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {

	}

	@Override
	public void deleteEmployee(int theId) {
		// TODO Auto-generated method stub

	}

}
