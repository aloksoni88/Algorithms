package com.doublylinkedlist;

public class ReverseList {
	public Node reverseList(Node head){
		/*if(head == null){
			System.out.println("List is empty");
			return head;
		}
		if(head.next == null){
			System.out.println("List has only 1 item ");
			return head;
		}
		Node tmp = null;
		Node current = head;
		while(current != null){
			tmp = current.prev;
			current.prev = current.next;
			current.next = tmp;
			current = current.prev;
		}
		if(tmp != null){
			head = tmp.prev;
		}*/
		head = reverseListRecursively(head);
		return head;
	}
	
	public Node reverseListRecursively(Node node){
		if(node == null){
			return node;
		}
		Node tmp = node.prev;
		node.prev = node.next;
		node.next = tmp;
		
		if(node.prev == null){
			return node;
		}
		return reverseListRecursively(node.prev);
	}
}
