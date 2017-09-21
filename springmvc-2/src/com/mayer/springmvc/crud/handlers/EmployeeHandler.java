package com.mayer.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String save(Employee employee,BindingResult result){
		System.out.println(employee);
		if(result.getErrorCount() > 0){
			System.out.println("出错了！");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
		}
		employeeDao.save(employee);
		return "redirect:/getEmps";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id")Integer id){
		employeeDao.delete(id);
		return "redirect:/getEmps";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id")Integer id,Map<String, Object> map){
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	@ModelAttribute()
	public void getEmp(@RequestParam(value="id",required=false)Integer id,Map<String, Object> map){
		if(id!=null){
			map.put("employee", employeeDao.get(id));
		}
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/getEmps";
	}
	
	/*@InitBinder
	public void testInitBinder(WebDataBinder binder){
		binder.setDisallowedFields("lastName");
	}*/
	
}
