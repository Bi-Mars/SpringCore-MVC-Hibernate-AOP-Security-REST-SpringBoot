package com.luv2code.springdemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//Initialize Service Class. Service Class will use DAO class to talk to database using Hibernate 
	@Autowired
	private CustomerService customerService;
	
	// add mapping to GET /customers
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	//add mapping for GET/customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable 	int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundException ("Customer id not found - " + customerId);
		}
		
		return theCustomer;
		
	}
	 
	//add mapping for POST/customers - add new customer --> Same Mapping but different request
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		//also just in case the user/client pass an id in JSON ... set id to 0
		// this force a save of a new item ... instead of update
		customer.setId(0); // insert not update
		
		// Delegate the call to Service layer, which uses DAO to communicate to database using Hibernate 
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	//add Mapping for PUT/customers - update existing customer --> Same Mapping but different request
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return customer;
	}

}
