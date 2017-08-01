package com.mayer.spring.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		NewPerson newperson = (NewPerson) ctx.getBean("newPerson");
		System.out.println(newperson);
		
		NewPersonMap newpersonmap =(NewPersonMap) ctx.getBean("newPersonMap");
		
		System.out.println(newpersonmap);
		
		NewPerson newperson4 = (NewPerson) ctx.getBean("newPerson4");
		System.out.println(newperson4);
		
		NewPerson newperson5 = (NewPerson) ctx.getBean("newPerson5");
		System.out.println(newperson5);
	}

}
