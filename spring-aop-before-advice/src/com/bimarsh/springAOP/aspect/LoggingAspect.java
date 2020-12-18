package com.bimarsh.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect //AspectJ
@Component
public class LoggingAspect {

	//this is where we add all of our related advices for logging
	
	//provide method signature
	@Before("execution(public void addAccount())") // run the method below, before "public void addAccount" is executed
	public void beforeAddAccountAdvice() {
		System.out.println("\n =============>>>> Executing @Before advice on addAccount()");
	}
	
}
