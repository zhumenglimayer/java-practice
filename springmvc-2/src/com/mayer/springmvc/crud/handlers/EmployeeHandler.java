package com.mayer.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mayer.springmvc.crud.dao.DepartmentDao;
import com.mayer.springmvc.crud.dao.EmployeeDao;
import com.mayer.springmvc.crud.entities.Employee;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping("/getEmps")
	public String list(Map<String, Object> map){
		map.put("Emps", employeeDao.getAll());
		return "list";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(Employee employee){
		employeeDao.save(employee);
		return "redirect:/getEmps";
	}
	
}
