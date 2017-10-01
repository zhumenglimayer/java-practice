package com.mayer.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayer.beans.User;
import com.mayer.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public boolean checkLogin(String userName, String password) {
		User user = userDaoImpl.findUserByName(userName);
		if(user != null&&user.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
