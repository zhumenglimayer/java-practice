package com.mayer.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomersDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Customers get(Integer id){
		String sql = "SELECT id, name, address, phone FROM customers WHERE id = ?";
		RowMapper<Customers> rowMapper = new BeanPropertyRowMapper<>(Customers.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
}
