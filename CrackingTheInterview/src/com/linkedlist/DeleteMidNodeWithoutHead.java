package com.linkedlist;

public class DeleteMidNodeWithoutHead {
	public static void main(String[] args) {
		MyLinkedList list =new MyLinkedList();
		list.addFirst(5);
		list.addLast(10);
		list.addLast(20);
		list.add(30);
		list.add(40);
		list.addLast(50);
		
		System.out.println(list.toString());
		
		list = list.deleteMidWithoutHead(list, 30);
		System.out.println(list);
	}
	
}
