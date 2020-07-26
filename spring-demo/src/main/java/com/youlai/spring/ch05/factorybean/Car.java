package com.youlai.spring.ch05.factorybean;

import lombok.Data;

/**
 * @author haoxr
 * @date 2020-06-10
 **/
@Data
public class Car {

	private int maxSpeed;

	private String brand;

	private double price;


	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
