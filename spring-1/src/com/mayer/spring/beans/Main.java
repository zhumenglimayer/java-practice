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
	}
}
