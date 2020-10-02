package com.alok.java8;

import java.util.Optional;

public class OptionalInJava {
	public static void main(String[] args) {
		String[] arr = new String[10];
		Optional<String> checkNull = Optional.ofNullable(arr[1]);
		checkNull.ifPresent(System.out::print);
		if(checkNull.isPresent()) {
			System.out.println(arr[0].toLowerCase());	
		}else {
			System.out.println("array does not have element");
		}
	}
}
