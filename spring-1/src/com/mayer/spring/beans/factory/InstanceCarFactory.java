package com.mayer.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceCarFactory {
	private Map<String, Car> cars = null;
	
	public InstanceCarFactory() {
		cars = new HashMap<String, Car>();
		cars.put("Audi", new Car("Audi", 300000));
		cars.put("Ford", new Car("Ford", 233333));
		
	}
	
	public Car getCar(String name){
		return cars.get(name);
	}
}
