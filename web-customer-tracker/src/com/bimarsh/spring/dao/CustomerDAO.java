package com.bimarsh.spring.dao;

import java.util.List;

import com.bimarsh.spring.entities.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

}