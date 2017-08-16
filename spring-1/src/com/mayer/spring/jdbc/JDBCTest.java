package com.mayer.spring.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class JDBCTest {

	ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private CustomersDao customersDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		customersDao = ctx.getBean(CustomersDao.class);
		namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
	}
	
	@Test
	public void testQueryForCustomerDao(){
		System.out.println(customersDao.get(2));
	}
	
	@Test
	public void testQueryforObject2(){
		String sql = "SELECT count(id) FROM customers";
		long count = jdbcTemplate.queryForObject(sql, long.class);
		System.out.println(count);
	}
	
	@Test
	public void testQueryForList(){
		String sql = "SELECT id, name, address, phone FROM customers WHERE id > ?";
		RowMapper<Customers> rowMapper = new BeanPropertyRowMapper<>(Customers.class);
		List<Customers> customers = jdbcTemplate.query(sql, rowMapper, 2);
		System.out.println(customers);
	}
	
	@Test
	public void testQueryForObject(){
		String sql = "SELECT id, name, address, phone FROM customers WHERE id = ?";
		RowMapper<Customers> rowMapper = new BeanPropertyRowMapper<>(Customers.class);
		Customers customer = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(customer);
	}
	
	@Test
	public void testBatchUpdata(){
		String sql = "INSERT INTO customers(name,address,phone) VALUES(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{"AA","AAA","1111"});
		batchArgs.add(new Object[]{"BB","BBB","2222"});
		batchArgs.add(new Object[]{"CC","CCC","333"});
		jdbcTemplate.batchUpdate(sql, batchArgs);
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
	
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "INSERT INTO customers(name, address, phone) VALUES(:name, :address, :phone) ";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", "ZML");
		paramMap.put("address", "NanJing");
		paramMap.put("phone", "12300009887");
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql = "INSERT INTO customers(name, address, phone) VALUES(:name, :address, :phone) ";
		Customers customer = new Customers();
		customer.setName("ZZZ");
		customer.setAddress("HaiKou");
		customer.setPhone("13977778888");
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(customer);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}

}
