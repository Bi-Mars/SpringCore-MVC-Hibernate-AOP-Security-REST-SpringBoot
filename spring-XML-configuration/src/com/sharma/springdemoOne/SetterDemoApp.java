package com.sharma.springdemoOne;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// Load the configuration File
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// crush the bean: retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on the bean
		System.out.println("Your Daily Workout: " + theCoach.getDailyWorkout());
		
		//call new method for fortune service
		System.out.println("Getting your fortune for today: " + theCoach.getDailyFortune());
		
		//call our new mehods to get literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		
		context.close();

	}

}
