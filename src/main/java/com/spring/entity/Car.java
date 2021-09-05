package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@Column(name = "CARNO")
	private String carNo;
	@Column(name = "CARMODEL")
	private String carModel;
	@Column(name = "TOPSPEED")
	private Integer topSpeed;
	
	
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public Integer getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(Integer topSpeed) {
		this.topSpeed = topSpeed;
	}
	
	
	
}
