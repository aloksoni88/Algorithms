package com.linkedlist;

public class KthToLastElement {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(12);
		list.add(11);
		list.add(12);
		list.add(21);
		list.add(41);
		list.add(43);
		list.add(21);
		list.add(63);
		
		System.out.println(list.toString());
		
		int item = kthElementFromLast(list,3);
		if(item == -1) {
			System.out.println("wrong index or list is empty or item not found");
		}else {
			System.out.println("Item found : " + item);
		}
	}
	
	private static int kthElementFromLast(MyLinkedList list,int index) {
		return list.getKthElementFromLast(index);
	}
}
