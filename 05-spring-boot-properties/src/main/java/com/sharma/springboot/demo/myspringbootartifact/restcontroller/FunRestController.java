package com.sharma.springboot.demo.myspringbootartifact.restcontroller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	//inject properties for: coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${coach.name}")
	private String teamName;
			
	//expose new endpoint for "teaminfo"
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + ", Team name: " + teamName;
	}
	
	// expose API endpoint
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}
	

	

}
