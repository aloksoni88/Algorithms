package com.alok.multithreading;

public class PrintOddEvenMain2 {
	int counter = 1;
	public static void main(String[] args) {
		PrintOddEvenMain2 main = new PrintOddEvenMain2();
		new Print1(main);
		new Print2(main);
	}
	
	public synchronized void printOddNumber() {
		if(counter % 2 == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(counter++);
		notify();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void printEvenNumber() {
		if(counter % 2 != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(counter++);
		notify();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class Print1 implements Runnable {
	PrintOddEvenMain2 main;
	public Print1(PrintOddEvenMain2 main) {
		this.main = main;
		new Thread(this,"OddNumber").start();
	}
	@Override
	public void run() {
		while(true) {
			if(main.counter >=10) {
				break;
			}
			main.printOddNumber();
		}
	}
}

class Print2 implements Runnable{
	PrintOddEvenMain2 main;
	public Print2(PrintOddEvenMain2 main) {
		this.main = main;
		new Thread(this,"EvenNumber").start();
	}
	@Override
	public void run() {
		while(true) {
			if(main.counter >= 10) {
				break;
			}
			main.printEvenNumber();
		}
	}
	
}

