package com.mayer.mybatis.crud.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mayer.mybatis.crud.beans.Department;
import com.mayer.mybatis.crud.beans.Employee;
import com.mayer.mybatis.crud.dao.EmployeeMapper;
import com.mayer.mybatis.crud.dao.EmployeeMapperDynamicSQL;
import com.mayer.mybatis.crud.dao.EmployeeMapperPlus;


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
			Employee employee = new Employee(null, "tom", "0", "tom@163.com");
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
			map.put("tableName", "tbl_employee");
			Employee employee = mapper.getEmpByMap(map);
			System.out.println(employee);
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
			
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testEmpsByLike() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			List<Employee> employees = mapper.getEmpsByLastNameLike("%e%");
			
			for (Employee employee : employees) {
				System.out.println(employee);
			}
			
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testEmpByIdReturnMap() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Map<String, Object> employee = mapper.getEmpByIdReturnMap(1);
			System.out.println(employee);
			
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testEmpByLastNameLikeReturnMap() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Map<Integer, Employee> employees = mapper.getEmpsByLastNameLikeReturnMap("%e%");
			System.out.println(employees);
			
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testEmpByIdResultMap() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpByIdResultMap(1);
			System.out.println(employee);
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testEmpAndDeptByIdResultMap() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpAndDeptByIdResultMap(1);
			System.out.println(employee);
			System.out.println(employee.getDepartment());
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testEmpAndDeptByIdByStep() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = mapper.getEmpByIdByStep(1);
			System.out.println(employee);
//			System.out.println(employee.getLastName());
			System.out.println(employee.getDepartment());
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testEmpsByDeptIdStep() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
			Department department = mapper.getEmpsByDeptIdStep(1);
//			System.out.println(department);
			System.out.println(department.getDepartmentName());
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testGetEmpsByConditionIf() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(null, "%e%", null, null);
			List<Employee> employees = mapper.getEmpsByConditionIf(employee);
			for (Employee emp : employees) {
				System.out.println(emp);
			}
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testGetEmpsByConditionChoose() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(null, null, null, null);
			List<Employee> employees = mapper.getEmpsByConditionChoose(employee);
			for (Employee emp : employees) {
				System.out.println(emp);
			}
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testUpdateEmpsByConditionSet() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(1, "Rose", null, null);
			mapper.updateEmpByConditionSet(employee);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testUpdateEmpsByConditionForeach() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> employees = mapper.getEmpsByConditionForeach(Arrays.asList(1,2,3,7,8));
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testaddEmpsByConditionForeach() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> emps = new ArrayList<>();
			emps.add(new Employee(null, "Mayer", "1", "mayer@163.com", new Department(1)));
			emps.add(new Employee(null, "Smith", "0", "smith@163.com", new Department(2)));
			mapper.addEmpsByConditionForeach(emps);
			sqlSession.commit();
			
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testGetEmpsBySql() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> employees = mapper.getEmpsBySql();
			for (Employee emp : employees) {
				System.out.println(emp);
			}
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testCache() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			
			Employee employee1 = mapper.getEmpById(1);
			Employee employee2 = mapper.getEmpById(1);
			System.out.println(employee1);
			System.out.println(employee1==employee2);
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testSecondLevelCache() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//获取到的sqlsession不会自动提交数据
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);
			Employee employee1 = mapper1.getEmpById(1);
			System.out.println(employee1);
			sqlSession1.close();
			Employee employee2 = mapper2.getEmpById(1);
			System.out.println(employee2);
			sqlSession2.close();
			System.out.println(employee1==employee2);
		}finally{
			
		}
	}

}
