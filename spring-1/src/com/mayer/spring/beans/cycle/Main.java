package com.mayer.spring.beans.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-cycle.xml");
		
		Car car = (Car) ctx.getBean("car");
		
		System.out.println(car);
		
		ctx.close();

	}

}
