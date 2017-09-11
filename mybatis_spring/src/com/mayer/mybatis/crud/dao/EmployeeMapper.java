package com.mayer.mybatis.crud.dao;


import java.util.List;

import com.mayer.mybatis.crud.beans.Employee;

public interface EmployeeMapper {
	
	
	public Employee getEmpById(Integer id);
	public List<Employee> getEmps();
	
}
