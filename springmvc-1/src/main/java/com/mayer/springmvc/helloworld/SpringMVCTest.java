package com.mayer.springmvc.helloworld;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mayer.springmvc.beans.User;
import com.sun.tracing.dtrace.ModuleAttributes;

//@SessionAttributes(value={"user"},types=String.class)
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
		System.out.println("testPathVariable...." + id +name);
		return "success";
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String testRestGET(@PathVariable("id")Integer id){
		System.out.println("testRest GET...." + id);
		return "success";
	}
	
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String testRestPOST(){
		System.out.println("testRest POST...." );
		return "success";
	}
	
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
	public String testRestPUT(@PathVariable("id")Integer id){
		System.out.println("testRest PUT...." + id);
		return "success";
	}
	
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.DELETE)
	public String testRestDELETE(@PathVariable("id")Integer id){
		System.out.println("testRest DELETE...." + id);
		return "success";
	}
	
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(value="username")String user,@RequestParam(value="age",required=false,defaultValue="0") int age){
		System.out.println("testRequestParam....user:" + user + "age :" + age);
		return "success";
	}
	
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String al){
		System.out.println("testRequestHeader....Accept-Language:" + al);
		return "success";
	}
	
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue(value="JSESSIONID")String jsessionid){
		System.out.println("testCookieValue....JSESSIONID:" + jsessionid);
		return "success";
	}
	
	@RequestMapping("/testPOJO")
	public String testPOJO(User user){
		System.out.println("testPOJO....UESR:" + user);
		return "success";
	}
	
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request,HttpServletResponse response,Writer out) throws IOException{
		System.out.println("testServletAPI.....");
		out.write("hello springmvc");
	}
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName = "success";
		ModelAndView modleAndView = new ModelAndView(viewName);
		modleAndView.addObject("timeeee", new Date());
		System.out.println("testModelAndView.....");
		return modleAndView;
	}
	
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map){
		map.put("names", Arrays.asList("Jerry","Tom","Rose"));
		System.out.println("testMap.....");
		return "success";
	}
	
	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String, Object> map){
		User user = new User("Tom", "123456", "Tom@163.com", "1", 15);
		map.put("user", user);
		map.put("school", "ZSMS");
		return "success";
	}
	
	
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String, Object> map){
		System.out.println("modelAttribute method....");
		if(id != null){
			User user = new User("1", "Tom", "123456", "Tom@163.com", "1", 12);
			System.out.println("从数据库取得的数据：" + user);
			map.put("user", user);
		}
	}
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println("修改后的:" + user);
		return "success";
	}
	
	@RequestMapping("/testBeanView")
	public String testBeanView(){
		System.out.println("testBeanView....");
		return "helloView";
	}
	
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect....");
		return "redirect:/index.jsp";
	}
}
