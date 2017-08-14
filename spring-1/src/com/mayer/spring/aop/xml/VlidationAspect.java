package com.mayer.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class VlidationAspect {
	
	public void validateArgs(JoinPoint joinpoint){
		System.out.println("validate:" + Arrays.asList(joinpoint.getArgs()));
	}
}
