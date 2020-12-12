package com.sharma.springDemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create an array of strings
	String[] fortune_Array = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The Journey is the reward"
	};

	//Random number
	
	private Random myRandom = new Random();
	
	@Override
	public String getDailyFortune() {

		//pick a random string from the array
		int index = myRandom.nextInt(fortune_Array.length);
		return fortune_Array[index];
	}

}
