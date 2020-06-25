package com.linkedlist;

public class Reverse {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println("Before reversing list...");
		System.out.println(list.toString());
		
		System.out.println();
		System.out.println("After reversing list...");
//		list.reverse();
//		list.reverseUsing2Variable();
//		list.reverseUsingStack();
		list.reverseRecurrsively();
		System.out.println(list.toString());
	}
}
