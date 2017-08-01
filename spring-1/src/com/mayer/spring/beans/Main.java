package com.mayer.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		HelloWorld hello1= new HelloWorld();
//		hello1.setName("lilili");
//		
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloWorld hello1= (HelloWorld)ctx.getBean("helloWorld");
		
		hello1.hello();
		
		Car car1 = (Car) ctx.getBean("car1");
		
		System.out.println(car1);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
