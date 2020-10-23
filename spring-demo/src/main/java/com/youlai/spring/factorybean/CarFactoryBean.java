<<<<<<< HEAD:spring-demo/src/main/java/com/youlai/spring/factorybean/CarFactoryBean.java
package com.youlai.spring.factorybean;
=======
package com.youlai.spring.ch05.factorybean;
>>>>>>> 690f2356eb1b94bf424194b8287d793bdb818aa6:spring-demo/src/main/java/com/youlai/spring/ch05/factorybean/CarFactoryBean.java

import org.springframework.beans.factory.FactoryBean;

/**
 * @author haoxr
 * @date 2020-06-10
 **/
public class CarFactoryBean implements FactoryBean<Car> {

	private String carInfo;

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.valueOf(infos[1]));
		car.setPrice(Double.valueOf(infos[2]));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
}
