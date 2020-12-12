package com.sharma.springDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

 

@Component
public class ReadFileFortuneService implements FortuneService {

	 List fortuneList = new ArrayList<String>();
	 
	 @Value("${fortune1}")
	 private String fortune1;
	 
	 @Value("${fortune2}")
	 private String fortune2;
	 
	 @Value("${fortune2}")
	 private String fortune3;

	 private Random myRandom = new Random();	 	 

	@Override
	public String getDailyFortune() {
		 fortuneList.add(fortune1);
		 fortuneList.add(fortune2);
		 fortuneList.add(fortune3);
		
		 int index = myRandom.nextInt(fortuneList.size());
		return (String) fortuneList.get(index);
	}

}
