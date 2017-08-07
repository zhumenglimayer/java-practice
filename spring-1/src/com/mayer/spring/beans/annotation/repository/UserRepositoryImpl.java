package com.mayer.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayer.spring.beans.annotation.TestObject;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired(required=false)
	private TestObject to;
	@Override
	public void save() {
		System.out.println("UserRepository save...");
		System.out.println(to);
	}

}
