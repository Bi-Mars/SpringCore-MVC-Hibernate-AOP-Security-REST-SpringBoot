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
					mapper.readValue(new File("data/sample-full.json"), StudentPojo.class);
			
			AddressPojo studentAddress = theStudent.getAddress();
			
			//use the data
			System.out.println(theStudent.getFirstName() + " " +
								theStudent.getLastName() + " " +
								"lives in " + theStudent.getAddress().getStreet() +
								", " + theStudent.getAddress().getCity() +
								", " + theStudent.getAddress().getState() +
								", " + studentAddress.getZip() +
								", " + studentAddress.getCountry() +
								" and likes:");
			
			//print lanaguegs:
			int count = 0;
			for(String tempLang : theStudent.getLanguages()) {
				System.out.println(++count + ". " +  tempLang );
			}


		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
