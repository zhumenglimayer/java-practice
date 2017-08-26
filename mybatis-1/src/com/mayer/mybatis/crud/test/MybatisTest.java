package com.mayer.mybatis.crud.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mayer.mybatis.helloworld.beans.Employee;
import com.mayer.mybatis.helloworld.dao.EmployeeMapper;
import com.mayer.mybatis.helloworld.dao.EmployeeMapperAnnotation;

public class MybatisTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-configs.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test() throws IOException {
		
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Employee employee = session.selectOne("com.mayer.mybatis.helloworld.EmployeeMapper.selectEmp", 1);
			System.out.println(employee);
		} finally {
			session.close();
		}

	}
	
	@Test
	public void testUseByInterface() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
		}finally{
			sqlSession.close();
		}
		
		
		
	}
	
	@Test
	public void testUseByAnnotation() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
			Employee employee = mapper.getEmpById(1);
			System.out.println(employee);
		}finally{
			sqlSession.close();
		}
		
	}

}
