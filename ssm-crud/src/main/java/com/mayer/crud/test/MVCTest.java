package com.mayer.crud.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.mayer.crud.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class MVCTest {
	
	@Autowired
	WebApplicationContext context;
//	虚拟MVC请求，得到处理结果
	MockMvc mockMvc;
	
	@Before
	public void initMockMVC(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
		MockHttpServletRequest request = result.getRequest();
		PageInfo pInfo = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码：" + pInfo.getPageNum());
		System.out.println("总页码：" + pInfo.getPages());
		System.out.println("总记录数：" + pInfo.getTotal());
		System.out.println("在页面需要连续显示的页码：");
		int[] nums = pInfo.getNavigatepageNums();
		for (int i : nums) {
			System.out.println(" " + i);
		}
		
		List<Employee> employees = pInfo.getList();
		for (Employee employee : employees) {
			System.out.println("ID:" + employee.getEmpId() + "==>Name:" + employee.getEmpName());
		}
	}
}
