package com.alok.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
	public static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

	public static void main(String[] args) {
		//CyclicBarrierExample example = new CyclicBarrierExample();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("No of parties required to trip the barrier = " + cyclicBarrier.getParties());

				Computation1 computation1 = new Computation1(40,50);
				Computation2 computation2 = new Computation2(20,30);
				
				Thread t1 = new Thread(computation1);
				Thread t2 = new Thread(computation2);
				
				t1.start();
				t2.start();
				
				
				try {
					CyclicBarrierExample.cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			
				Thread thread = new Thread(new CyclicBarrierExample().action);
				thread.start();
				
				//CyclicBarrierExample.cyclicBarrier.reset();
			}
		}).start();
	}

	Runnable action = new Runnable() {

		@Override
		public void run() {
			System.out.println("Product is : " + Computation1.product);
			System.out.println("Sum is : " + Computation2.sum);
			System.out.println("Result is =" + (Computation1.product + Computation2.sum));
		}
	};

}

class Computation1 implements Runnable {
	public static int product = 0;

	int a,b;
	public Computation1(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public void run() {
		product = a * b;
		try {
			CyclicBarrierExample.cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class Computation2 implements Runnable {
	public static int sum = 0;

	int a,b;
	public Computation2(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public void run() {
		// check if newBarrier is broken or not
		System.out.println("Is the barrier broken? - " + CyclicBarrierExample.cyclicBarrier.isBroken());
		sum = a + b;
		try {
			CyclicBarrierExample.cyclicBarrier.await();

			// number of parties waiting at the barrier
			System.out.println("Number of parties waiting at the barrier " + "at this point = "
					+ CyclicBarrierExample.cyclicBarrier.getNumberWaiting());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		} 
	}
}
