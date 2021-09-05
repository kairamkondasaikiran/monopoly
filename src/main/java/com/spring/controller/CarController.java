package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Car;
import com.spring.service.CarServiceIntrface;

@RestController
public class CarController {

	@Autowired
	CarServiceIntrface carService;
	
	
	@RequestMapping("findCar")
	public List<Car> findCar() {
		
		System.out.println("Something");
	return	carService.findAll();
	
	}
	
	@PostMapping("addCar")
	public String addCar(@RequestBody Car car) {
		
	return	carService.addCar(car);
	}
	
	@GetMapping("getCarByNumber/{carNumber}")
	public Car getCarByNumber(@PathVariable("carNumber") String carNumber) {
		
		return carService.getCarByNumber(carNumber);
	}
	@PutMapping("upDateCar")
	public String upDateCar(@RequestBody Car car) {
		
		
		return carService.upDateCar(car);
	}
}
