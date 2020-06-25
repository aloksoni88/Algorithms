package com.linkedlist;

import java.util.LinkedList;

public class Partioning {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
//		list.add(1);
//		list.add(4);
//		list.add(3);
//		list.add(2);
//		list.add(5);
//		list.add(2);
//		list.add(3);
		list.add(1);
		list.add(4);
		list.add(2);
		list.add(10);
		list.add(3);
		
		int partitionValue = 2;
		System.out.println("Before Partitioning...");
		System.out.println(list.toString());
		
		System.out.println();
		list.partition(partitionValue);
		System.out.println("After Partitioning...");
		System.out.println(list.toString());

//		l.add(10);
//		l.add(20);
//		l.add(2,30);
//		System.out.println(l.toString());
	}
}
