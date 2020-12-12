package com.sharma.springdemoOne;

public class TennisCoach implements Coach{

	private FortuneService fortuneService;
	
	public TennisCoach() {}
	
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Jumping Jack for 15 minutes and Swing Practice for 1 hour";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
