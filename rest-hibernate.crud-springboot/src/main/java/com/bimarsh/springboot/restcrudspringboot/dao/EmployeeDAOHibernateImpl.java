package com.bimarsh.springboot.restcrudspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bimarsh.springboot.restcrudspringboot.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
	
	//Define field for EntityManager --> wrapper for SessionFactory
	private EntityManager entityManager;
	
	//Setup constructor Injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query 
		Query<Employee> theQuery =
				currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//return the results
		return employees;
	}

	@Override
	public Employee findByEmployeeId(int theId) {
		
		//get session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get employee 
		Employee theEmployee =
				currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		//if primary key is 0 then save/insert else update
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteEmployee(int theId) {
		
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee 
		// Employee theEmployee = currentSession.get(Employee.class, theId); // OR
		Query theQuery =
				currentSession.createQuery(
						"delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
