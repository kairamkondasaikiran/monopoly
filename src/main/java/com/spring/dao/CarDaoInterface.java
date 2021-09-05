package com.spring.dao;

import java.util.List;

import com.spring.entity.Car;

public interface CarDaoInterface {

	public List<Car> findAll();
	
	public Car getCarByNumber(String carNumber);
	
	public String addCar(Car car);
	
	public String deleteCarByNumber(String carNumber);
	
	public String upDateCar(Car car);
}

