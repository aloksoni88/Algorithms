package com.alok.multithreading;

public class PrintOddEvenMain {
	boolean isEven;
	public static void main(String[] args) {
		
		PrintOddEvenMain main = new PrintOddEvenMain();
		new PrintThread1(main);
		new PrintThread2(main);
		
	}
	
	public synchronized void printOddNumber(int number) {
		if(isEven) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(number);
		isEven = true;
		notify();
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void printEvenNumber(int number) {
		if(!isEven) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(number);
		isEven = false;
		notify();
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PrintThread1 implements Runnable {
	PrintOddEvenMain main;
	public PrintThread1(PrintOddEvenMain main) {
		this.main = main;
		new Thread(this,"OddNumber").start();
	}
	@Override
	public void run() {
		for(int i=1; i<10; i=i+2) {
			main.printOddNumber(i);
		}
	}
}

class PrintThread2 implements Runnable{
	PrintOddEvenMain main;
	public PrintThread2(PrintOddEvenMain main) {
		this.main = main;
		new Thread(this,"EvenNumber").start();
	}
	@Override
	public void run() {
		for(int i=2; i<=10; i=i+2) {
			main.printEvenNumber(i);
		}
	}
	
}

