package com.bimarsh.springAOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bimarsh.springAOP.dao.AccountDAO;

public class MainAOP {

	public static void main(String[] args) {
		
		//read spring configuration java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringAOPConfig.class);
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		//make another call to the method to check if @Before runs again
		System.out.println("\n----------------- Let's call it again ----------------\n");
		theAccountDAO.addAccount();
		
		//close the context
		context.close();

	}

}
