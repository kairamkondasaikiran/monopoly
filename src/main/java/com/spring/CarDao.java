package com.spring;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Car;

@Repository
@Transactional
public class CarDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	 @PersistenceContext
	private EntityManager entity;
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Car> findCar() {
		Session session= null;
		List<Car> c = new ArrayList<Car>();
		
		try {
			session = sessionFactory.openSession();
			
			String query = "select * from car ";
		
			c=  (List<Car>) session.createNamedQuery(query).getResultList();
	
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		session.close();
		return c;
	}
	
}
