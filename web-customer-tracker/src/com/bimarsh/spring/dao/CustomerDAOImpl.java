package com.bimarsh.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bimarsh.spring.entities.Customer;

@Repository // only for DAO implementation 
public class CustomerDAOImpl implements CustomerDAO {

	//inject the session factory so that this DAO can use to talk to database from Hibernate Factory 
	@Autowired
	private SessionFactory sessionFactory; // this sessionFactory must match bean id in .xml file
	
	
	@Override
	public List<Customer> getCustomers() {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();		
		
		//create a query ... sort by last name
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		//execute query and get result 
		List<Customer> customers = theQuery.getResultList();
		
		//result the result
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer updateCustomer(int theId) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get data from database (customer) using primary key i.e. id
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {

		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete the customer using customer id --> query to handle delete
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		//generate purpose 
		theQuery.executeUpdate();
		
	}

}
