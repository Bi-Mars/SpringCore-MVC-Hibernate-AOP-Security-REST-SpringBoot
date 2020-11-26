package com.sharma.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OptionMarketCoach implements Coach {
	
	//default constructor 
	public OptionMarketCoach() {}
	
	private FortuneService fortuneService;
	
	//constructor for injecting (bean) dependency
	@Autowired
	public OptionMarketCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		
		return "Understand Delta and Volatility";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
