package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Car;

@Repository
@Transactional
public class CarDaoImpl implements CarDaoInterface{

	@Autowired
	private EntityManager entityManger;
	
	@Override
	public List<Car> findAll() {
		
	Session session=	entityManger.unwrap(Session.class);
	Query<Car> query  = session.createQuery("from Car", Car.class);
	 List<Car> listCar=query.getResultList();
	 session.close();
	 return listCar;
	}

	@Override
	public Car getCarByNumber(String carNumber) {
		
		Session session = entityManger.unwrap(Session.class);
	    Car c=   session.get(Car.class, carNumber);
	   
	    session.close();
	    return c;
	    
	}

	@Override
	public String addCar(Car car) {
		
		Session session=	entityManger.unwrap(Session.class);
		session.save(car);
		return "Saved New Car";
		
	}

	@Override
	public String deleteCarByNumber(String carNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upDateCar(Car car) {
		
		Session session = entityManger.unwrap(Session.class);
		session.saveOrUpdate(car);
		session.close();
		return "UpDated Successfully";
	}

}
