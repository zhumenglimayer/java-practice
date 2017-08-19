package com.mayer.spring.structs2.beans;

public class Person {
	private String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void hello(){
		System.out.println("My name is: " + userName);
	}
}
