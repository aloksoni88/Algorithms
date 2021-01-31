package com.alok.executer.framework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class StopThread {
	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Callable<Object> task = new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				for(int i=0; i<10; i++) {
					Thread.sleep(1000);
				}
				return "Task has been finished...";
			}
		};
		
		Future<Object> futrue = service.submit(task);
		try {
			Object result = futrue.get(5000, TimeUnit.MILLISECONDS);
			System.out.println(result);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		finally {
			service.shutdownNow();
		}
	}
}
