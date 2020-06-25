package com.linkedlist;

public class RemoveDuplicates {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(12);
		list.add(11);
		list.add(12);
		list.add(21);
		list.add(41);
		list.add(43);
		list.add(21);
		list.add(43);
		
		System.out.println(list.toString());
		list = removeDuplicates(list);
		System.out.println(list.toString());
	}
	
	private static MyLinkedList removeDuplicates(MyLinkedList list) {
		return list.removeDuplicates(list);
	}
}
