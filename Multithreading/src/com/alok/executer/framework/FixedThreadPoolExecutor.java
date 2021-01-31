package com.alok.executer.framework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FixedThreadPoolExecutor {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		Task1 task1 = new Task1();
		Future<String> futureObj1 = executorService.submit(task1);
		
		
		Task2 task2 = new Task2();
		Future<String> futureObj2 = executorService.submit(task2);
		
		
		Task3 task3 = new Task3();
		//Future<String> futureObj3 = executorService.submit(task3);
		
		try {
			System.out.println(futureObj1.get());
			System.out.println(futureObj2.get());
			//System.out.println(futureObj3.get(5000, TimeUnit.MILLISECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} 
//		catch (TimeoutException e) {
//			e.printStackTrace();
//		}
		executorService.shutdownNow();
		
	}
}

class Task1 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		for(int i=0; i<10; i++) {
			System.out.println("Task1, i=" + i);			
			Thread.sleep(1000);
			if(i==3) {
				int x = 3/0;
			}
		}
		return "My first Task";
	}
	
}

class Task2 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		for(int i=10; i<20; i++) {
			System.out.println("Task2, i=" + i);
			Thread.sleep(1000);
		}
		return "My second Task";
	}
	
}

class Task3 implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		for(int i=20; i<30; i++) {
			System.out.println("Task3, i=" + i);
			Thread.sleep(1000);
		}
		return "My third Task";
	}
	
}
