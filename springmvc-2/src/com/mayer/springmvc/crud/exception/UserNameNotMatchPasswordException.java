package com.mayer.springmvc.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="用户和密码不匹配")
public class UserNameNotMatchPasswordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
