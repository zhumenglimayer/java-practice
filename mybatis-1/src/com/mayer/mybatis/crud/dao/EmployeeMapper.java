package com.mayer.mybatis.crud.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.mayer.mybatis.crud.beans.Employee;

public interface EmployeeMapper {
	
	@MapKey("id")
	public Map<Integer, Employee> getEmpsByLastNameLikeReturnMap(String lastName);
	
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String, Object> map);
	
	public Employee getEmpByUseActualParamName(Integer id, String lastName);
	
	public Employee getEmpByIdLastName(@Param("id")Integer id, @Param("lastName")String lastName);
	
	public Employee getEmpById(Integer id);
	
	public void addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteEmp(Integer id);
}
