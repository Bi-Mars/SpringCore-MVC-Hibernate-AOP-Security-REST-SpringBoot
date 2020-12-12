package com.sharma.springdemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	
	public static void main(String[] args ) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve bean from Spring Container
		Coach theCoach = context.getBean("myCoach", TennisCoach.class);
		
		//call methods on the bean
		System.out.println("Your Daily Workout: " + theCoach.getDailyWorkout());
		
		//call new method for fortune service
		System.out.println("Getting your fortune for today: " + theCoach.getDailyFortune());
		
		//close the context (container)
		context.close();
		
	}

}
