package com.alok.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class YieldDemo {
	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
		
		MyThread t = new MyThread();
		t.setName("custom");
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
		
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
		System.out.println(t.getName() + " " + t.getPriority());

		for (int i = 0; i < 5; i++) {
			// Control passes to child thread
			Thread.yield();

			// After execution of child Thread
			// main thread takes over
			System.out.println(Thread.currentThread().getName() + " in control");
		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
	}
}

class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++)
			System.out.println(Thread.currentThread().getName() + " in control");
	}
}