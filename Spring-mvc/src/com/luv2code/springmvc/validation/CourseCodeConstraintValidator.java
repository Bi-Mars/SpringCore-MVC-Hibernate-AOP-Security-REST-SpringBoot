package com.luv2code.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	@Override
	public boolean isValid(String userData, ConstraintValidatorContext constraintValidatorContext) {
		
		// does data provided by the user starts with our desired value?
		boolean result = true;
		//check for null
		if(userData !=null) {
		   result =	userData.startsWith(coursePrefix);

		}
	
		return result;
	}

}
