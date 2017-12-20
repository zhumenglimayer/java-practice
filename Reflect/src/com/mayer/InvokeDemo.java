package com.mayer;

import java.lang.reflect.Method;

public class InvokeDemo {
	public static void main(String[] args) {
		A a1 = new A();
		Class c = a1.getClass();
		try {
			Method m1 = c.getMethod("print");
			m1.invoke(a1);
			System.out.println("==================================");
		} catch (Exception e) {	
			e.printStackTrace();
		} 
		try {
			Method m2 = c.getMethod("print",int.class,int.class);
			m2.invoke(a1,11,22);
			System.out.println("==================================");
		} catch (Exception e) {	
			e.printStackTrace();
		} 
		try {
			Method m3 = c.getMethod("print",String.class,String.class);
			m3.invoke(a1,"hello","world");
		} catch (Exception e) {	
			e.printStackTrace();
		} 
	}
}

class A {
	public void print() {
		System.out.println("111111111111");
	}

	public void print(int a, int b) {
		System.out.println(a+b);
	}

	public void print(String a, String b) {
		System.out.println(a + " " + b);
	}
}