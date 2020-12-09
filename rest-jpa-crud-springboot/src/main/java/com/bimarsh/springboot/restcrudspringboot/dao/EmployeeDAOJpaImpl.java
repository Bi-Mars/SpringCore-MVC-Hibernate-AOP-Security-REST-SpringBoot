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
		
		//get employee by id
		Employee theEmployee = 
				entityManager.find(Employee.class, theId);
		
		//return the employee
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		//save or update the employee: if primaryKey == 0 then insert or update else update
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with id from db  .... so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteEmployee(int theId) {
		
		//create query
		Query theQuery = entityManager.createQuery(
				"delete from Employee where id=:employeeId");
		
		//provide employeeId
		theQuery.setParameter("employeeId", theId);
		
		// execute the query
		theQuery.executeUpdate();
	}

}
