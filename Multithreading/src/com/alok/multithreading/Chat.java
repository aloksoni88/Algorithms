package com.alok.multithreading;

public class Chat {
	private boolean flag = false;
	
	public synchronized void question(String message) {
		if(flag) {
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
		System.out.println(message);
		flag = true;
		notify();
	}
	
	public synchronized void answer(String message) {
		if(!flag) {
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
		System.out.println(message);
		flag = false;
		notify();
	}
	
	public static void main(String[] args) {
		Chat chat = new Chat();
				
		Thread t1 = new Thread(new T1(chat));
		Thread t2 = new Thread(new T2(chat));
		
		t1.start();
		t2.start();
	}
	
}

class T1 implements Runnable{
	Chat c;
	String[] str = {"Hi","How r u?","I am too fine"};
	public T1(Chat c) {
		this.c =c;

	}
	@Override
	public void run() {
		for(int i=0; i<str.length; i++) {
			c.question(str[i]);
		}
	}
}

class T2 implements Runnable{

	Chat c;
	String[] str = {"Hi","I am doing good, How about u?","Great..."};
	public T2(Chat c) {
		this.c =c;
		new Thread(this,"Answer");
	}
	
	@Override
	public void run() {
		for(int i=0; i<str.length; i++) {
			c.answer(str[i]);
		}
	}
}
