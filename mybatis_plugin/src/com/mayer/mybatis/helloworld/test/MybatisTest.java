package com.mayer.mybatis.helloworld.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.mayer.mybatis.crud.beans.Employee;
import com.mayer.mybatis.crud.beans.EmployeeExample;
import com.mayer.mybatis.crud.beans.EmployeeExample.Criteria;
import com.mayer.mybatis.crud.dao.EmployeeMapper;

public class MybatisTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-configs.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	
	@Test
	public void testPlugin() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee emp = employeeMapper.selectByPrimaryKey(1);
			System.out.println(emp.getLastName());
		} finally {
			sqlSession.close();
		}
		
	}


}
