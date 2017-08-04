package com.mayer.spring.beans.properties;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mayer.spring.beans.autowire.Address;
import com.mayer.spring.beans.autowire.Car;
import com.mayer.spring.beans.autowire.Person;

public class Main {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-properties.xml");
		
		DataSource datasource = (DataSource) ctx.getBean("datasource");
		
		
		System.out.println(datasource.getConnection());
	}

}
