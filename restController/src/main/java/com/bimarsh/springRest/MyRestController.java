package com.bimarsh.springRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyRestController {
	
	//add code for the "/hello" endpoint
	@GetMapping("/hello")
	public String sayHellow() {
		return "Hello Bimarsh";
	}

}
