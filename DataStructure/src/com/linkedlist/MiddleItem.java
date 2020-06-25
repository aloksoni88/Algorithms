package com.linkedlist;

public class MiddleItem {
	public int middleItem(Node head){
		if(head == null){
			return -1;
		}
		Node tmp = head;
		Node fast = head;
		while(fast != null && fast.next != null){
			tmp = tmp.next;
			fast = fast.next.next;
		}
		if(tmp != null){
			return tmp.data;
		}
		return -1;
	}
}
