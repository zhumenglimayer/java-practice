package com.mayer.spring.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTest {

	ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
	@Test
	public void testUpdate(){
		String sql = "UPDATE customers SET address = ? where id = ?";
		jdbcTemplate.update(sql, "HangZhou", 3);
	}
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
