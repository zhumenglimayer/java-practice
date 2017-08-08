package com.mayer.spring.aop.helloworld;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class ArithmeticCalculatorLoggingProxy {
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy = null;
		ClassLoader loader = target.getClass().getClassLoader();
		
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
				String methodName = arg1.getName();
				System.out.println("The method " + methodName + " begins with"+Arrays.asList(arg2));
				Object result = arg1.invoke(target, arg2);
				System.out.println("The method " + methodName + " ends with" + result);
				return result;
			}
		};
		
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
