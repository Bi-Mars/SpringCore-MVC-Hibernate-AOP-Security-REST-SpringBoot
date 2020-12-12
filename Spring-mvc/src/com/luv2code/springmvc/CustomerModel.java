package com.luv2code.springmvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springmvc.validation.CourseCode;

public class CustomerModel {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	//this is new field for number range
	@Min(value=0, message="Must be Greater than or equal to zero")
	@Max(value=10, message="Must be less than or equal to 10")
	@NotNull(message="You must provide value to this field")
	private Integer freePasses;
	
	//apply regular expression for this field
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Only 5 characters or Digits")
	private String zipCode;
	
	@CourseCode(value="FUNNY", message="Course Code starts with FUNNY")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
