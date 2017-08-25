package com.mayer.mybatis.helloworld.dao;

import org.apache.ibatis.annotations.Select;

import com.mayer.mybatis.helloworld.beans.Employee;

public interface EmployeeMapperAnnotation {
	
	@Select("SELECT * FROM tbl_employee where id = #{id}")
	public Employee getEmpById(Integer id);
}
