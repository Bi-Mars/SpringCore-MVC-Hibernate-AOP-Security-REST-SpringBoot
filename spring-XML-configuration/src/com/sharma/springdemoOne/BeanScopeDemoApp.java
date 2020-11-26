package com.sharma.springdemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		//load the configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve Bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// Alpha Coach
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if they are same bean
		boolean result = (theCoach == alphaCoach);
		System.out.println("\nPointing to same object? " + result);
		
		//print memory location
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach);
		
		//close the context
		context.close();


		
		
	}

}
