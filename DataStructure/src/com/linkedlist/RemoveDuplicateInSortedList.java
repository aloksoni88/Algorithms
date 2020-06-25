package com.linkedlist;

public class RemoveDuplicateInSortedList {
	public void removeDuplicates(Node head){
		Node tmp = head;
		while(tmp != null){
			if(tmp !=null && tmp.next != null && tmp.data == tmp.next.data){
				tmp.next = tmp.next.next;
			}else{
				tmp = tmp.next;
			}
		}
	}
}
