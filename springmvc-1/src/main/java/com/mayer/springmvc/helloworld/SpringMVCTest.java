package com.mayer.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	
	
	@RequestMapping(value="testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMetnod....");
		return "success";
	}
	
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping....");
		return "success";
	}
	
	@RequestMapping("/testPathVariable/{id}/{name}")
	public String testPathVariable( @PathVariable(value="id") Integer id,@PathVariable(value="name") String name){
		System.out.println("testPathVariable...." + id + name);
		return "success";
	}
}
