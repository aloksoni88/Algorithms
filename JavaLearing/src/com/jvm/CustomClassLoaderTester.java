package com.jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassLoaderTester {
	public static void main(String[] args) {
		CustomClassLoaderDemo demo = new CustomClassLoaderDemo();
		try {
			Class<?> c = demo.findClass("com.jvm.CustomClassLoaderTestClass");
			Object obj = c.newInstance();
			Method method = c.getMethod("show");
			method.invoke(obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {		
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
