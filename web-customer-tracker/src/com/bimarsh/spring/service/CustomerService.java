package com.bimarsh.spring.service;

import java.util.List;

import com.bimarsh.spring.entities.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);
	
}
