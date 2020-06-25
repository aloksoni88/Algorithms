package com.linkedlist;

public class SwapPairElement {
	public void swapPairElements(Node head){
		if(head == null){
			System.out.println("List is empty");
			return;
		}else if(head.next == null){
			System.out.println("Only 1 Item in the list");
			return;
		}
		Node curr = head;
		while(curr != null && curr.next != null){
			int value = curr.data;
			curr.data = curr.next.data;
			curr.next.data = value;
			
			curr = curr.next.next;
		}
	}
}
