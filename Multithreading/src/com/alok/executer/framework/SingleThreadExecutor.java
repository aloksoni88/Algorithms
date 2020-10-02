package com.alok.executer.framework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Future<String> future = executor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Hello";
			}
		});
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
		
		executor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("New Single thread executor example");
			}
		});
		
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("jksj");
				
			}
		});
		
		executor.shutdown();
	}
}
