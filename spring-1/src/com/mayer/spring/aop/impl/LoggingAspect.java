package com.mayer.spring.aop.impl;

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
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* com.mayer.spring.aop.impl.*.*(int, int))")
	public void beforeMeth(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+ methodName +" begins with"+ args);
	}
	
	@After("execution(* com.mayer.spring.aop.impl.*.*(int, int))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" ends");
	}
	
	@AfterReturning(value="execution(* com.mayer.spring.aop.impl.*.*(int, int))", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" ends withs" + result);
	}
	
	@AfterThrowing(value="execution(* com.mayer.spring.aop.impl.*.*(int, int))", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method "+ methodName +" occurs exception:" + ex);
	}
	
	@Around("execution(* com.mayer.spring.aop.impl.*.*(int, int))")
	public void aroundMethod(ProceedingJoinPoint pjp){
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
	}
}
