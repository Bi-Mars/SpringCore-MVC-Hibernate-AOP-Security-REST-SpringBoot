package com.sharma.springdemoOne;

import java.util.Random;

public class RandomFortune implements FortuneService {

	String[] list_of_fortunes = {"Today is your day to win", "watch out you might make silly mistake", "Today you really need to watch out for yourself"};
	
	Random random = new Random();
	int randomInt = random.nextInt(3);
	
	@Override
	public String getFortune() {
		return list_of_fortunes[randomInt];
	}

}
