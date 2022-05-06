package com.alok.multithreading;

public class CountUsingTwoThread {
	
	boolean isEven = false;
	public static void main(String[] args) {
		CountUsingTwoThread countUsingTwoThread = new CountUsingTwoThread();
		
		Thread t1 = new Thread(new Thread1(countUsingTwoThread));
		
		Thread t2 = new Thread(new Thread2(countUsingTwoThread));
		
		t1.start();
		t2.start();
	}
	
	
	private synchronized void print1(int counter) {
		if(isEven) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isEven = true;
		System.out.println("Thread 1 : " + counter);
		notify();
	}
	
	private synchronized void print2(int counter) {
		if(!isEven) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isEven = false;
		System.out.println("Thread 2 : " + counter);
		notify();
	}
	
	static class Thread1 implements Runnable{
		private CountUsingTwoThread instance;
		
		public Thread1(CountUsingTwoThread instance) {
			this.instance = instance;
		}
		@Override
		public void run() {
			for(int i=1; i<=10; i=i+2) {
//				System.out.println("Thread 1: i="+i);
				instance.print1(i);
			}
		}
		
	}
	
	static class Thread2 implements Runnable{
		private CountUsingTwoThread instance;
		
		public Thread2(CountUsingTwoThread instance) {
			this.instance = instance;
		}
		@Override
		public void run() {
			for(int i=2; i<=10; i=i+2) {
//				System.out.println("Thread 2: i="+i);
				instance.print2(i);
			}
		}
		
	}
}


