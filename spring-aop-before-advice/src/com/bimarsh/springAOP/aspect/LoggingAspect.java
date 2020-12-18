package com.bimarsh.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect //AspectJ
@Component
public class LoggingAspect {

	//this is where we add all of our related advices for logging
	
	//provide method signature
	@Before("execution (* add*(com.bimarsh.springAOP.Account))")  
	public void beforeAddAccountAdvice() {
		System.out.println("\n =============>>>> Executing @Before advice on add *");
	}
	
}
