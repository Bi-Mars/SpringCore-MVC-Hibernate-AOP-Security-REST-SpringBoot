package com.bimarsh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bimarsh.spring.dao.CustomerDAO;
import com.bimarsh.spring.entities.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Inject DAO into this controller
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model customerModel) {
		
		//get customers from the DAO
		List<Customer> customers = customerDAO.getCustomers();
		
		//add the customers to the model
		customerModel.addAttribute("customers", customers); // provide attribute name and value
		
		return "list-customer";
	}

}
