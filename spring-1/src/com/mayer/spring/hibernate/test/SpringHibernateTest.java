package com.mayer.spring.hibernate.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mayer.spring.hibernate.service.BookShopService;
import com.mayer.spring.hibernate.service.Cashier;

public class SpringHibernateTest {

	private ApplicationContext ctx = null;
	private BookShopService bookShopService= null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("aa", "1001");
	}
	
	@Test
	public void testCashier(){
		cashier.checkOut("aa", Arrays.asList("1001","1002"));
	}

}
