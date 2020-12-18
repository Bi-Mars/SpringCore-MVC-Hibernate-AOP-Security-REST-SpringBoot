package com.bimarsh.springAOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bimarsh.springAOP.dao.AccountDAO;
import com.bimarsh.springAOP.dao.MembershipDAO;

public class MainAOP {

	public static void main(String[] args) {
		
		//read spring configuration java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SpringAOPConfig.class);
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//get Membership bean fro spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		//call the membership business method
		theMembershipDAO.addAccount();
		
		//make another call to the method to check if @Before runs again
		System.out.println("\n---------------------------------------- Let's call it again -------------------------------------------------\n");
		theAccountDAO.addAccount();
		
		//close the context
		context.close();

	}

}
