package com.sharma.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

	public static void main(String[] args) {

		// Register or load the configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean
		Coach sillyCoach = context.getBean("tennisCoach", Coach.class);
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
