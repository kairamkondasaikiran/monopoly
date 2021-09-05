package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.spring")
public class SpringBootWithHibernateApplication {


	
	public static void main(String[] args) {
		
	
		SpringApplication.run(SpringBootWithHibernateApplication.class, args);
	}

}
