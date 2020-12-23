package com.alok.multithreading;

public class ThreadViaRunnable implements Runnable {
	@Override
	public void run() {		
		System.out.println("Thread name ="+ Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		ThreadViaRunnable thread = new ThreadViaRunnable();
		Thread t = new Thread(thread);
		t.setName("fsf");
		t.start();
	}
}
