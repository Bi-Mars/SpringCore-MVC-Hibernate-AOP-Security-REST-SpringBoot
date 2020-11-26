package com.luv2code.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//Need a controller method to SHOW the initial HTML FORM
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//Need a Controller method to PROCESS the HTML Form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new controller method to read form data and add data to the model
	@RequestMapping("/letsShoutDude")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from HTML form
		String theName =  request.getParameter("studentName");
		//process the data: convert to all UpperCase
		theName = theName.toUpperCase();
		//create more message
		String result = "Yo! " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return"helloworld";
	}
	
	
	// @RequestParam Demo
		// new controller method to read form data and add data to the model
		@RequestMapping("/letsShoutDudeVersionTwo")
		public String letsShoutDudeVersionTwo( @RequestParam("studentName") String theName, Model model) {
			
			//process the data: convert to all UpperCase
			theName = theName.toUpperCase();
			//create more message
			String result = "Hello from V2! " + theName;
			
			//add message to the model
			model.addAttribute("message", result);
			
			return"helloworld";
		}
}
