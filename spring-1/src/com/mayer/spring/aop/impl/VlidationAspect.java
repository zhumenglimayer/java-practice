package com.mayer.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VlidationAspect {
	
	@Before("execution(public * com.mayer.spring.aop.impl.*.*(int,int))")
	public void validateArgs(JoinPoint joinpoint){
		System.out.println("validate:" + Arrays.asList(joinpoint.getArgs()));
	}
}
