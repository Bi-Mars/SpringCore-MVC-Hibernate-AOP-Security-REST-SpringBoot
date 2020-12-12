package com.sharma.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve the bean
		Coach sillyCoach = context.getBean("swimCoach", Coach.class);
		Coach optionCoach = context.getBean("optionMarketCoach", OptionMarketCoach.class);

		
		// call method to get the daily fortune
		System.out.println(sillyCoach.getDailyFortune());
		
		// use the bean
		System.out.println("Daily workout: " + sillyCoach.getDailyWorkout());
		System.out.println("Daily workout: " + optionCoach.getDailyWorkout());
		
		//clean up
		context.close();

	}

}
