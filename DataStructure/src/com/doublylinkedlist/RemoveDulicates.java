package com.doublylinkedlist;

public class RemoveDulicates {
	public Node removeDuplicated(Node head){
		if(head == null){
			System.out.println("List is empty");
			return head;
		}
		if(head.next == null){
			System.out.println("List has only 1 item");
			return head;
		}
		Node current = head;
		Node tmp = null;
		while(current != null){
			int counter = 0;
			while(tmp != null && current != null && current.data == tmp.data){
				counter++;
				current = current.next;
			}
			if(counter > 0){
				tmp.next = current;
				if(current != null){
					current.prev = tmp;
				}
			}
			tmp = current;
			if(current != null){
				current = current.next;
			}
		}
		return head;
	}
}
