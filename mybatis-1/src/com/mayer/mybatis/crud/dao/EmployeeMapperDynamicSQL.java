package com.mayer.mybatis.crud.dao;

import java.util.List;

import com.mayer.mybatis.crud.beans.Employee;

public interface EmployeeMapperDynamicSQL {
	public List<Employee> getEmpsByConditionIf(Employee employee);
	public List<Employee> getEmpsByConditionChoose(Employee employee);
}
