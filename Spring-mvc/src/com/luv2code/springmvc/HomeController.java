package com.luv2code.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	//step 2: define controller method
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}
