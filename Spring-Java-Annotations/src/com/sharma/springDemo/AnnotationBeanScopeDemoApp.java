package com.sharma.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		// load the configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

		
		//are bean same?
		boolean result= (theCoach == alphaCoach);
		
		//print out result
		System.out.println("\n Pointing to same object? " + result);
		System.out.println("\n Memory Location for theCoach? " + theCoach);
		System.out.println("\n Memory Location for alphaCoach? " + alphaCoach);
		
		//close the conatiner
		context.close();

		
	}

}
