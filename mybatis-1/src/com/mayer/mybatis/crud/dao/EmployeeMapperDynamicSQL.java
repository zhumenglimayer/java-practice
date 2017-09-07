package com.mayer.mybatis.crud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mayer.mybatis.crud.beans.Employee;

public interface EmployeeMapperDynamicSQL {
	public List<Employee> getEmpsByConditionIf(Employee employee);
	public List<Employee> getEmpsByConditionChoose(Employee employee);
	public void updateEmpByConditionSet(Employee employee);
	public List<Employee> getEmpsByConditionForeach(List<Integer> ids);
	public void addEmpsByConditionForeach(@Param("emps")List<Employee> emps);
	public List<Employee> getEmpsBySql();
}
