package com.oppsprinciple;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class SuperClass {
	public SuperClass(){
		this(10);
		System.out.println("super class no-arg constructor");
	}
	
	public SuperClass(int a){
		this("abc");
		System.out.println("super class int-arg constructor");
	}

	public SuperClass(String s){
		System.out.println("super class string-arg constructor");
	}
	
	protected int sameMethodDiffReturntype() throws SocketTimeoutException, IOException {
		return -1;
	}
}

class SubClass extends SuperClass{
	public SubClass(){
		this(10);
		System.out.println("sub class no-arg constructor");
	}
	
	public SubClass(int a){
		this("abc");
		System.out.println("sub class int-arg constructor");
	}
	
	

	public SubClass(String s){
		System.out.println("sub class string-arg constructor");
	}
	
	//will give an error
//	@Override
//	protected int sameMethodDiffReturntype() {
//		
//	}
	
	@Override
	protected int sameMethodDiffReturntype() throws IOException{
		return 0;
	}
}
