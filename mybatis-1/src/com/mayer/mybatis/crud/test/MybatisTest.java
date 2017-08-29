package com.mayer.mybatis.crud.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
	@Test
	public void test03() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", 1);
			map.put("lastName", "jerry");
			Employee employee = mapper.getEmpByMap(map);
			
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
	
	/*useActualParamName的使用*/
	@Test
	public void test04() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmpByUseActualParamName(1, "jerry");
			
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
