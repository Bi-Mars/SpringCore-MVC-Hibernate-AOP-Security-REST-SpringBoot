package com.sharma.springdemoOne;

public class MyApp {
	public static void main(String[] args) {
		//Create the object
		Coach trackCoach = new TrackCoach();
		
		//use the object
		System.out.println(trackCoach.getDailyWorkout());
	}
}
