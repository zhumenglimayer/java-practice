package com.mayer.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayer.beans.User;
import com.mayer.dao.UserDao;
import com.mayer.dao.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByName(String userName) {
		return userMapper.getUserByName(userName);
	}

}
