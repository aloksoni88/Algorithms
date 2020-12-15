package com.jvm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoaderDemo extends ClassLoader {
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] bt = loadClassData(name);
		return defineClass(name, bt, 0, bt.length);
	}
	
	private byte[] loadClassData(String className) {
		InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".","/")+".class");
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		
		int len = 0;
		try {
			while((len = is.read()) != -1) {
				byteStream.write(len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return byteStream.toByteArray();
	}
	
}
