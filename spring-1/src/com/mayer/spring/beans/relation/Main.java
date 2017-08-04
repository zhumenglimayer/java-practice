package com.mayer.spring.beans.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mayer.spring.beans.autowire.Address;
import com.mayer.spring.beans.autowire.Car;
import com.mayer.spring.beans.autowire.Person;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-relation.xml");
		
		Address address = (Address) ctx.getBean("address2");
		
		System.out.println(address);
		
		address = (Address) ctx.getBean("address3");
		
		System.out.println(address);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
		Car car1 = (Car) ctx.getBean("car");
		Car car2 = (Car) ctx.getBean("car");
		System.out.println(car1==car2);
	}

}
