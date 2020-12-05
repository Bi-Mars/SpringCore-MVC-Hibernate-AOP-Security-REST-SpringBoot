package com.bimarsh.jackson.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//create object mapper
			ObjectMapper mapper = new ObjectMapper(); //from Jackson project
			
			//read JSON file and map/convert to Java POJO: 
			// data/sample-lite.json
			
			StudentPojo theStudent =
					mapper.readValue(new File("data/sample-lite.json"), StudentPojo.class);
			
			//use the data
			System.out.println("First Name = " + theStudent.getFirstName());
			System.out.println("Last Name = " + theStudent.getLastName());

		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
