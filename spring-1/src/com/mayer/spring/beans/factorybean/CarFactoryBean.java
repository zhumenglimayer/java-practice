package com.mayer.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Factory;

public class CarFactoryBean implements FactoryBean<Car> {

	private String brand;
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Car(brand, 500000);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}


}
