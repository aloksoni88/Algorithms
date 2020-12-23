package com.alok.multithreading;

public class ThreadViaExtend extends Thread{
	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName());
	}

	
	
	public static void main(String[] args) {
		ThreadViaExtend thread = new ThreadViaExtend();
		thread.setName("xzhksdf");		
		thread.start();
	}
}
