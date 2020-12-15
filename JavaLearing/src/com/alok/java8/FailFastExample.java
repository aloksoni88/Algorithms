package com.alok.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class FailFastExample {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4,5}));
		
		//list.forEach((element) -> System.out.println(element));
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer element) {	
				if(element == 2) {
					list.add(10);
				}
				System.out.println(element);
			}
		});
		System.out.println();
		Iterator<Integer> it = list.iterator();
	
		while(it.hasNext()) {
			int value = it.next();
			if(value == 3) {
				list.remove(3);
				continue;
			}
			System.out.println(value);
		}
	}
}
