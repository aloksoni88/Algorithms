package com.linkedlist;

public class NthItemFromLast {
	public int nthItemFromLast(Node head,int n){
		if(head == null){
			return -1;
		}else if(n == 0){
			return -1;
		}
		Node mainNode = head;
		Node refNode = head;
		int counter = 0;
		if(refNode != null){
			while(counter < n){
				if(refNode == null){
					System.out.println("nth item is more than the no of item in list");
					return -1;
				}
				refNode = refNode.next;
				counter++;
			}
		}
		
		while(refNode != null){
			mainNode = mainNode.next;
			refNode = refNode.next;
		}
		return mainNode.data;
		
	}
	
}
