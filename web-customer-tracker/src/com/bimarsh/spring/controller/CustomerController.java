package com.bimarsh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimarsh.spring.entities.Customer;
import com.bimarsh.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Use Service Layer
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model customerModel) {
		
		//get customers from the Service Layer
		List<Customer> customers = customerService.getCustomers();
		
		//add the customers to the model
		customerModel.addAttribute("customers", customers); // provide attribute name and value
		
		return "list-customer";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind Form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}

}
