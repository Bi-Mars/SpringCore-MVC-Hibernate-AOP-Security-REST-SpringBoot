package com.sharma.springdemoOne;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	//Empty Constructor 
	public TrackCoach() {}
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: inside method doMyStatUpStuff");
	}
	
	//add a destory method
	public void doMyCleanUpStuffYo() {
		System.out.println("TrackCoach: inside method doMyCleanUpStuffYo");
	}

}
