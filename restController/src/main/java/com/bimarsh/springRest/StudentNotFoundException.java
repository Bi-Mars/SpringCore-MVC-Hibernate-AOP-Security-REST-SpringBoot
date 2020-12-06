package com.bimarsh.springRest;

public class StudentNotFoundException extends RuntimeException{
	
	//constructors

	public StudentNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable arg0) {
		super(arg0);
	}

	
	
	

}
