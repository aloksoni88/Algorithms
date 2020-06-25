package com.circularlinkedlist;

import com.linkedlist.Node;

public class SortedInsert {
	public Node insert(Node head,int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			newNode.next = head;
			return head;
		}
		Node tmp= head;
		if(tmp.data > data){
			newNode.next = tmp;
			head = newNode;
			tmp.next= head;
			return head;
		}
	
		do{
			tmp = tmp.next;
		}while(tmp.next != head && tmp.next.data < data);
		newNode.next = tmp.next;
		tmp.next = newNode;
		return head;
	}
}
