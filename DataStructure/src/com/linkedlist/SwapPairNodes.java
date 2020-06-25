package com.linkedlist;

public class SwapPairNodes {
	public Node swapPairNode(Node head){
		if(head == null){
			System.out.println("List is empty");
			return head;
		}else if(head.next == null){
			System.out.println("Only 1 Item in the list");
			return head;
		}
		Node curr = head;

		while(curr != null && curr.next != null){
			head = new SwapNodes().swapNode(head, curr.data, curr.next.data);
			curr = curr.next;
		}
		return head;
	}

}
