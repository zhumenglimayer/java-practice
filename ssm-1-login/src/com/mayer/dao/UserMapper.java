package com.mayer.dao;

import com.mayer.beans.User;

public interface UserMapper {
	public User getUserByName(String userName);
}
