package com.mayer.mybatis.helloworld.dao;

import com.mayer.mybatis.helloworld.beans.Employee;

public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
}
