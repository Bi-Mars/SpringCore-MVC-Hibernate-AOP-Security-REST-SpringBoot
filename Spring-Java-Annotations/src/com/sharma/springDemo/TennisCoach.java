package com.sharma.springDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	//default constructor 
	public TennisCoach()
	{
		System.out.println(">> Tennis Coach: inside Default constructor");
	}
	
	//define custom init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> TennisCoach: Inside of doMyStartUpStuff()");
	}
	
	//define custom destroy method
	@PreDestroy
	public void doMyCleanUpStuff(){
		System.out.println(">> TennisCoach: Inside of doMyCleanUpStuff()");

	}
	
	@Autowired
	@Qualifier("readFileFortuneService")
	private FortuneService fortuneService;
	
	

	// define Setter Method
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println(">> Tennis Coach: inside setFortuneService");
//		this.fortuneService = fortuneService;
//	}
//	
//	//Define any method
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println(">> Tennis Coach: doSomeCrazyStuff");
//		this.fortuneService = fortuneService;
//	}
	
//	//constructor for injecting (bean) dependency
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practise Swing for 1 hour";
	}
	
	//use the injected (bean)dependency

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
