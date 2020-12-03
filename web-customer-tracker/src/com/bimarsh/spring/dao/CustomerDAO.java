package com.bimarsh.spring.dao;

import java.util.List;

import com.bimarsh.spring.entities.CustomerEntity;

public interface CustomerDAO {
	
	public List<CustomerEntity> getCustomers();

}
