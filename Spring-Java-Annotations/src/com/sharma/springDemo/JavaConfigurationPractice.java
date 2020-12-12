package com.sharma.springDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigurationPractice {
	
	@Bean
	public UltimateFortune ultimateFortune() {
		return new UltimateFortune();
	}
	
	//dependency Injection
	@Bean
	public SubstituteCoach substituteCoach() {
		return new SubstituteCoach(ultimateFortune());
	}
	

}
