package com.mayer.mybatis.crud.dao;

import java.util.List;

import com.mayer.mybatis.crud.beans.Department;
import com.mayer.mybatis.crud.beans.Employee;

public interface EmployeeMapperPlus {
	public Employee getEmpByIdResultMap(Integer id);
	
	public Employee getEmpAndDeptByIdResultMap(Integer id);
	
	public Employee getEmpByIdByStep(Integer id);
	
	public Department getEmpsByDeptIdStep(Integer id); 
}
