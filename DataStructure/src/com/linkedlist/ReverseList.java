package com.linkedlist;

public class ReverseList {
	public Node reverseList(Node head){
		/*if(head == null){
			System.out.println("List is empty");
			return head;
		}
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;*/
		return reverseListRecurive(head, null);
	}
	
	public Node reverseListRecurive(Node current, Node prev){
		if(current.next == null){
			current.next = prev;
			return current;
		}
		Node next = current.next;
		current.next = prev;
		prev = current;
		return reverseListRecurive(next, prev);
	}
}
