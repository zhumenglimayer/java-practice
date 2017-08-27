package com.mayer.mybatis.crud.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mayer.mybatis.crud.beans.Employee;
import com.mayer.mybatis.crud.dao.EmployeeMapper;


public class MybatisTest {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-configs.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	
	
	@Test
	public void test01() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//添加
			Employee employee = new Employee(null, "jerry", "1", "jerry@163.com");
			mapper.addEmp(employee);
			System.out.println(employee.getId());
			
			//修改
//			Employee employee = new Employee(1, "jerry", "1", "jerry@163.com");
//			mapper.updateEmp(employee);
			
			
			//删除
//			mapper.deleteEmp(4);
			
			
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
		
		
	}
	
	@Test
	public void test02() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			
			Employee employee = mapper.getEmpByIdLastName(1, "jerry");
			
			System.out.println(employee);
			
			//修改
//			Employee employee = new Employee(1, "jerry", "1", "jerry@163.com");
//			mapper.updateEmp(employee);
			
			
			//删除
//			mapper.deleteEmp(4);
			
			
		}finally{
			sqlSession.close();
		}
		
		
		
	}

}
