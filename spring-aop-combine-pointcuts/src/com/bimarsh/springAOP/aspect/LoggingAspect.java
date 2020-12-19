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
	
	//pointcut for setters
	@Pointcut("execution(* com.bimarsh.springAOP.dao.*.set*(..))")
	private void setDaoPackage() {}
	
	//pointcut for getters
	@Pointcut("execution(* com.bimarsh.springAOP.dao.*.get*(..))")
	private void getDaoPackage() {}
	
	//create pointcut: include package ... execute getter/setter
	@Pointcut("forDaoPackage() && !(setDaoPackage() || getDaoPackage())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	//Apply pointcut declaration to advice
	@Before("forDaoPackageNoGetterSetter()") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n =============>>>> Executing @Before advice on add *");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n =============>>>> Performing API analytics");
	}
	
}
