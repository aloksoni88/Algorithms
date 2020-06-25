package com.doublylinkedlist;

public class DeleteNode {
	public Node deleteNode(Node head, int data){
		if(head == null){
			System.out.println("List is empty");
			return head;
		}
		if(head.data == data){
			head.next.prev = null;
			head = head.next;
			return head;
		}
		Node tmp =head;
		Node prev = head;
		while(tmp != null && tmp.data != data){
			prev = tmp;
			tmp = tmp.next;
		}
		if(tmp == null){
			System.out.println();
			System.out.println("data not found to delete");
			return head;
		}
		else if(tmp.next != null){
			prev.next = tmp.next;
			tmp.next.prev = prev;
		}else{
			prev.next = null;
		}
		return head;
	}
}
