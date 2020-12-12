package com.sharma.springdemoOne;

public class BaseballCoach implements Coach {
	
	//define private field for dependency injection
	private FortuneService fortuneService;
	
	//Empty Constructor
	public BaseballCoach() {}

	//define a constructor for dependency injection
	public BaseballCoach(FortuneService thefortuneService) {
		this.fortuneService = thefortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		//use my fortuneService to get a fortune (helper object to get the service)
		return fortuneService.getFortune();
	}
}
