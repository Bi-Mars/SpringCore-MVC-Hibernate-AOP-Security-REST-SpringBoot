package com.sharma.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UltimateSubstitueJavaConfigDemoApp {

	public static void main(String[] args) {

		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(JavaConfigurationPractice.class);
		
		// retrieve the bean
		Coach sillyCoach = context.getBean("substituteCoach", Coach.class);

		
		// call method to get the daily fortune
		System.out.println(sillyCoach.getDailyFortune());
		
		// use the bean
		System.out.println("Daily workout: " + sillyCoach.getDailyWorkout());
	
		context.close();

	}

}
