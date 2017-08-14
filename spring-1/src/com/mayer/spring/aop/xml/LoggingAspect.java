package com.mayer.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class LoggingAspect {
	
	public void declareJoinPointExpression(){
		
	}
	
	public void beforeMeth(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+ methodName +" begins with"+ args);
	}
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" ends");
	}
	
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" ends withs" + result);
	}
	
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" occurs exception:" + ex);
	}
	
	/*
	@Around("declareJoinPointExpression()")
	public Object aroundMethod(ProceedingJoinPoint pjp){
		Object result = null;
		String methodName = pjp.getSignature().getName();
		
		try {
			System.out.println("The method "+ methodName +" begins with"+ Arrays.asList(pjp.getArgs()));
			result = pjp.proceed();
			System.out.println("The method "+ methodName +" ends withs" + result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("The method "+ methodName +" occurs exception:" + e);
		}
		System.out.println("The method "+ methodName +" ends");
		return result;
	}
	*/
		
}
