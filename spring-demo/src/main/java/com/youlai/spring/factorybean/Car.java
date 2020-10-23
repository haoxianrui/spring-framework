<<<<<<< HEAD:spring-demo/src/main/java/com/youlai/spring/factorybean/Car.java
package com.youlai.spring.factorybean;
=======
package com.youlai.spring.ch05.factorybean;
>>>>>>> 690f2356eb1b94bf424194b8287d793bdb818aa6:spring-demo/src/main/java/com/youlai/spring/ch05/factorybean/Car.java

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
