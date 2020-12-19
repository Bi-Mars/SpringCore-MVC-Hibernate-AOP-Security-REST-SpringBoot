package com.bimarsh.springAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect //AspectJ
@Component
public class LoggingAspect {

	
	// create point cut declaration
	@Pointcut("execution (* com.bimarsh.springAOP.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//Apply pointcut declaration to advice
	@Before("forDaoPackage()") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n =============>>>> Executing @Before advice on add *");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n =============>>>> Performing API analytics");
	}
	
}