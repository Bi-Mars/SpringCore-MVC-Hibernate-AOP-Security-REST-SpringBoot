package com.luv2code.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	//call method to show form
	@RequestMapping("/showForm")
	public String showForm(Model studentModel) {
		
		// create a new Student object
		StudentModel theStudent = new StudentModel();
		
		// add student object to our Model attribute
		studentModel.addAttribute("student", theStudent);
		
		//return this view-page
		return "student-form";
		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") StudentModel studentModel) {
		
		//return this view-page
		return "student-confirmation";
	}
	
}
