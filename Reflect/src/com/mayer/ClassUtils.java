package com.mayer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.activation.FileDataSource;

public class ClassUtils {

	public static void printClassMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("类的名称是" + c.getName());
		Method[] ms = c.getMethods();
		for (Method method : ms) {
			Class returnType = method.getReturnType();
			System.out.print(returnType.getName() + " ");

			System.out.print(method.getName() + "(");
			Class[] paramTypes = method.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}

	}

	public static void printFiledMessage(Object obj) {
		Class c = obj.getClass();
		Field[] fld = c.getDeclaredFields();
		System.out.println("成员变量");
		for (Field field : fld) {
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);
		}
	}
	
	public static void printConstructorsMessage(Object obj){
		Class c = obj.getClass();
		Constructor[] cus = c.getDeclaredConstructors();
		System.out.println("构造函数");
		for (Constructor constructor : cus) {
			System.out.print(constructor.getName() + "(");
			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName() + ",");
			}
			System.out.println(")");
		}
		
	}

}
