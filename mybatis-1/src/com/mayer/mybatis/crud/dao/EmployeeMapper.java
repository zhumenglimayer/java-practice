package com.mayer.mybatis.crud.dao;

import com.mayer.mybatis.crud.beans.Employee;

public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	
	public void addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteEmp(Integer id);
}
