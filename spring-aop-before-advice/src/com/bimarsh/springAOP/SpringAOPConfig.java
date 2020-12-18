package com.bimarsh.springAOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Spring Pure Java Configuration
@EnableAspectJAutoProxy  // Spring AOP Proxy Support
@ComponentScan("com.bimarsh.springAOP") // Component Scan
public class SpringAOPConfig {

}
