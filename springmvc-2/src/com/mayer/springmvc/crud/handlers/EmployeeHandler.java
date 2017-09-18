package com.mayer.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mayer.springmvc.crud.dao.EmployeeDao;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/getEmps")
	public String list(Map<String, Object> map){
		map.put("Emps", employeeDao.getAll());
		return "list";
	}
	
}
