package com.mayer.dao;

import com.mayer.beans.User;

public interface UserDao {
	public User findUserByName(String userName);
}
