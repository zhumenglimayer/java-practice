package com.mayer.mybatis.crud.dao;

import java.util.List;

import com.mayer.mybatis.crud.beans.Department;
import com.mayer.mybatis.crud.beans.Employee;

public interface DepartmentMapper {
	public Department getDeptById(Integer id);
	public List<Employee> getEmpsById(Integer id);
}
