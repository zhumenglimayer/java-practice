package com.mayer.spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		ArithmeticCalculator arithmeticCalculator = null;
		arithmeticCalculator = new ArithmeticCalculatorImpl();
		int result = arithmeticCalculator.add(1, 3);
		System.out.println("---->" + result);
		
		result = arithmeticCalculator.div(4, 2);
		System.out.println("---->" + result);
	}

}
