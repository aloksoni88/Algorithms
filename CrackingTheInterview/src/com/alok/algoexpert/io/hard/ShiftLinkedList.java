/**
 * 
 */
package com.alok.algoexpert.io.hard;

/**
 * @author Alok Soni
 *
 */
public class ShiftLinkedList {
	public static void main(String[] args) {
		var head = new LinkedList(0);
		head.next = new LinkedList(1);
		head.next.next = new LinkedList(2);
		head.next.next.next = new LinkedList(3);
		head.next.next.next.next = new LinkedList(4);
		head.next.next.next.next.next = new LinkedList(5);
		LinkedList result = shiftLinkedList(head, 8);
		while(result != null) {
			System.out.print(result.value + "->");
			result = result.next;
		}
		System.out.print("null");
	}

	//Time - O(n)
	//Space - O(1)
	public static LinkedList shiftLinkedList(LinkedList head, int k) {
		if (k == 0) {
			return head;
		}
		LinkedList current = head;
		int count = 0;
		while (current != null) {
			current = current.next;
			count++;
		}
		k = k % count;
		if (k == 0) {
			return head;
		}
		int kthNode = k > 0 ? count - k : Math.abs(k);
		current = head;
		count = 1;
		while (count != kthNode) {
			current = current.next;
			count++;
		}
		LinkedList newHead = current.next;
		LinkedList tmp = newHead;
		while (tmp != null && tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = head;
		head = newHead;
		current.next = null;
		return head;
	}

	static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			next = null;
		}
	}

}
