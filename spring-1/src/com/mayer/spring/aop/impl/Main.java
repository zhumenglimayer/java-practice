package com.mayer.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-impl.xml");
		
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		
		int result = arithmeticCalculator.add(2, 3);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(9, 3);
		System.out.println("result:" + result);
		
	}

}
