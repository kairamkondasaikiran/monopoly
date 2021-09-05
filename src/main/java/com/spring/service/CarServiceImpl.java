package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CarDaoInterface;
import com.spring.entity.Car;

@Service
public class CarServiceImpl implements CarServiceIntrface{

	@Autowired
	CarDaoInterface carDao;
	
	
	@Override
	public List<Car> findAll() {

		
		return carDao.findAll();
	}

	@Override
	public Car getCarByNumber(String carNumber) {
		
	return	carDao.getCarByNumber(carNumber);
	}

	@Override
	public String addCar(Car car) {
		
	return	carDao.addCar(car);
	
	}

	@Override
	public String deleteCarByNumber(String carNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upDateCar(Car car) {
		
	 return	carDao.upDateCar(car);
	}

	

}
