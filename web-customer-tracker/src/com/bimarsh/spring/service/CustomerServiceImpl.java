package com.bimarsh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bimarsh.spring.dao.CustomerDAO;
import com.bimarsh.spring.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject dependency DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional // auto begin and commit transaction
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		//service layer talks to DAO talks to Hibernate API talks to database
		customerDAO.saveCustomer(theCustomer);
	}

}
