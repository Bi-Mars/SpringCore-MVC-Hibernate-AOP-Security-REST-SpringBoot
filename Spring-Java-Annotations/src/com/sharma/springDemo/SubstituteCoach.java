package com.sharma.springDemo;

public class SubstituteCoach implements Coach {
	
	private UltimateFortune ultimateFortune;
	
	
	public SubstituteCoach(UltimateFortune ultimateFortune) {
		this.ultimateFortune = ultimateFortune;
	}

	@Override
	public String getDailyWorkout() {
		return "Have fun";
	}

	@Override
	public String getDailyFortune() {
		return ultimateFortune.getDailyFortune();
	}

}
