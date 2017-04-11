package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan("com.example.dao")
public class ApplicationRun extends SpringBootServletInitializer{

	// jar启动 
	public static void main(String[] args) {
		SpringApplication.run(ApplicationRun.class, args);
	}
	
	// tomcat war启动  
	 @Override  
     protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
         return application.sources(ApplicationRun.class);  
     }
	
}
