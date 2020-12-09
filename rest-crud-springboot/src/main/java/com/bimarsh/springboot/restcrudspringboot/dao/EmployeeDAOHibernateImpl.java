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
	@Transactional // handles transaction management so we don't have to manually start and commit transaction
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

}
