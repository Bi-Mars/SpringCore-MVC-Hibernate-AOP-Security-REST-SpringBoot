package com.bimarsh.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bimarsh.spring.entities.Customer;

@Repository // only for DAO implementation 
public class CustomerDAOImpl implements CustomerDAO {

	//inject the session factory so that this DAO can use to talk to database from Hibernate Factory 
	@Autowired
	private SessionFactory sessionFactory; // this sessionFactory must match bean id in .xml file
	
	
	@Override
	@Transactional // auto begin and commit transaction
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();		
		
		//create a query
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer", Customer.class);
		
		//execute query and get result 
		List<Customer> customers = theQuery.getResultList();
		
		//result the result
		return customers;
	}

}
