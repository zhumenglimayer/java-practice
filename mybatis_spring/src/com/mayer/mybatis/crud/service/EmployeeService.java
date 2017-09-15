package com.mayer.mybatis.crud.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayer.mybatis.crud.beans.Employee;
import com.mayer.mybatis.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private SqlSession sqlSession;
	public List<Employee> getEmps(){
		return employeeMapper.getEmps();
	}
}
