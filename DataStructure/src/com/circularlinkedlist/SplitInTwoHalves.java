package com.circularlinkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.linkedlist.Node;

public class SplitInTwoHalves {
	public List<Node> spilitList(Node head){
		if(head == null){
			System.out.println("List is empty");
			return null;
		}
		if(head.next == null){
			System.out.println("List has only 1 item");
			return new ArrayList<Node>(Arrays.asList(head));
		}
		List<Node> nodeList = new ArrayList<Node>();
		Node fast = head;
		do{
			Node head1 = null;
			head1 = push(head1, fast.data);
			head1 = push(head1, fast.next.data);
			nodeList.add(head1);
			fast = fast.next.next;
		}while(fast != head && fast.next!= head);
		
		if(fast != head){
			Node head1 = null;
			head1 = push(head1, fast.data);
			nodeList.add(head1);
		}
		return nodeList;
	}
	
	public Node push(Node head,int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			newNode.next = head;
			return head;
		}else{
			Node tmp = head;
			while(tmp.next != head){
				tmp = tmp.next;
			}
			tmp.next = newNode;
			newNode.next = head;
			return head;
		}
	}
}
