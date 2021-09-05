package com.spring.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*@Configuration
*/
public class HibernateConfig {

	/*
	 * @Autowired private EntityManagerFactory entityManagerFactory;
	 * 
	 * 
	 * public SessionFactory getSessionFactory() {
	 * 
	 * if(entityManagerFactory.unwrap(SessionFactory.class) == null ) { throw new
	 * NullPointerException("Factory is not SessionFactory"); } return
	 * entityManagerFactory.unwrap(SessionFactory.class); }
	 */
	
	
}
