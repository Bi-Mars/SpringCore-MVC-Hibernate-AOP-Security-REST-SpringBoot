package com.sharma.springDemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	@Value("${fortune1}")
	private String firstFortune;
	
	//create a method
	@PostConstruct
	public void readInitFortune() {
		System.out.println("read from file: " + firstFortune);
		
	}

	@Override
	public String getDailyFortune() {
		return "You will accomplish if you just go for it.";
	}

}
