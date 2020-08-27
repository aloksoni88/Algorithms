package com.alok.multithreading;

import java.util.Random;

public class InterThreadCommunication {
	public static void main(String args[]) {
		final Customer c = new Customer();
		Thread thread1 = new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				c.deposit(10000);
			}
		};
		thread1.start();
		thread2.start();
		
		
	}
}

class Customer {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("going to withdraw..." + amount);

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed, Balanced remaining : " + this.amount);
		
	}

	synchronized void deposit(int amount) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("going to deposit..."  + amount);
		this.amount += amount;
		System.out.println("deposit completed... " + amount);
		notify();
	}
}
