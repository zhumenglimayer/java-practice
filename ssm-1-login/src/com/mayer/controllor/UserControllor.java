package com.mayer.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mayer.Impl.UserServiceImpl;
import com.mayer.beans.User;

@Controller
public class UserControllor {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user){
		boolean flag = userServiceImpl.checkLogin(user.getUserName(), user.getPassword());
		if(flag){
			return "success";
		}
		return "failed";
	}
}
