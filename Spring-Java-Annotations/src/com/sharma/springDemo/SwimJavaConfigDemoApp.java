package com.sharma.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve the bean
		SwimCoach sillyCoach = context.getBean("swimCoach", SwimCoach.class);

		
		// call method to get the daily fortune
		System.out.println(sillyCoach.getDailyFortune());
		
		// use the bean
		System.out.println("Daily workout: " + sillyCoach.getDailyWorkout());
		
		//call our new swim coach methods .... has the properties values injected
		System.out.println("email: " + sillyCoach.getEmail());
		System.out.println("team: " + sillyCoach.getTeam());
		//clean up
		context.close();

	}

}
