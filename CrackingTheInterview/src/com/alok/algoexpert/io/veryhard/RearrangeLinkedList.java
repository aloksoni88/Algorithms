/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

/**
 * @author Alok Soni
 *
 */
public class RearrangeLinkedList {
	public static void main(String[] args) {
		LinkedList head = new LinkedList(3);
		head.next = new LinkedList(0);
		head.next.next = new LinkedList(5);
		head.next.next.next = new LinkedList(2);
		head.next.next.next.next = new LinkedList(1);
		head.next.next.next.next.next = new LinkedList(4);
		System.out.println(head);
		
//		LinkedList head = new LinkedList(0);
//		head.next = new LinkedList(3);
//		head.next.next = new LinkedList(2);
//		head.next.next.next = new LinkedList(1);
//		head.next.next.next.next = new LinkedList(4);
//		head.next.next.next.next.next = new LinkedList(5);
//		head.next.next.next.next.next.next = new LinkedList(3);
//		head.next.next.next.next.next.next.next = new LinkedList(-1);
//		head.next.next.next.next.next.next.next.next = new LinkedList(-2);
//		head.next.next.next.next.next.next.next.next.next = new LinkedList(3);
//		head.next.next.next.next.next.next.next.next.next.next = new LinkedList(6);
//		head.next.next.next.next.next.next.next.next.next.next.next = new LinkedList(7);
//		head.next.next.next.next.next.next.next.next.next.next.next.next = new LinkedList(3);
//		head.next.next.next.next.next.next.next.next.next.next.next.next.next = new LinkedList(2);
//		head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new LinkedList(-9000);
//		System.out.println(head);
		LinkedList rearrangedList = rearrangeLinkedList(head, 3);
		System.out.println(rearrangedList);
	}

	public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
		if(head == null) {
			return head;
		}
		boolean isArrangementNeeded = false;
		LinkedList prev = null, current = head,currentArrangedNode = null;		
		while(current != null) {
			if(current.value <= k) {		
				if(!isArrangementNeeded) {
					prev = current;
					current = current.next;
					if(currentArrangedNode == null) {
						currentArrangedNode = head;
					}else {
						currentArrangedNode = currentArrangedNode.next;
					}
				}else {
					LinkedList tmp =  current;
					prev.next = current.next;
					current = current.next;
					if(current == null) {
						tmp.next = head;
						head = tmp;
					}else if(currentArrangedNode == null) {
						tmp.next = prev;
						head = tmp;	
						currentArrangedNode = head;
					}else {
						tmp.next = currentArrangedNode.next;	
						currentArrangedNode.next = tmp;									
						currentArrangedNode = currentArrangedNode.next;					
					}	
				}																
			}else {	
				isArrangementNeeded = true;
				prev = current;
				current = current.next;	
			}			
		}
		return head;
	}

	static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			next = null;
		}
		
		@Override
		public String toString() {			
			StringBuilder builder = new StringBuilder(value + "->");
			LinkedList current = next;
			while(current != null) {				
				if(current.next != null) {
					builder.append(current.value + "->");					
				}else {
					builder.append(current.value);
				}
				current = current.next;
			}
			return builder.toString();
		}
	}
}
