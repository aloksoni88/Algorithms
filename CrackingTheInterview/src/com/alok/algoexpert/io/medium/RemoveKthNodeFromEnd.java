/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 *
 */
public class RemoveKthNodeFromEnd {

	public static void main(String[] args) {

		LinkedList list = new LinkedList(0);
		LinkedList head = list;

		list = list.next = new LinkedList(1);
		// list = list.next;
		list = list.next = new LinkedList(2);
		list = list.next = new LinkedList(3);
		list = list.next = new LinkedList(4);
		list = list.next = new LinkedList(5);
		list = list.next = new LinkedList(6);
		list = list.next = new LinkedList(7);
		list = list.next = new LinkedList(8);
		list = list.next = new LinkedList(9);
		removeKthNodeFromEnd(head, 10);

		System.out.println();
		LinkedList current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
	}

	public static void removeKthNodeFromEnd(LinkedList head, int k) {
		// Write your code here.
		LinkedList current = head;
		LinkedList fastNode = head;

		int counter = 0;
		while (counter < k) {
			if (fastNode == null) {
				break;
			}
			fastNode = fastNode.next;
			counter++;
		}
		if (fastNode == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}

		while (fastNode.next != null) {
			fastNode = fastNode.next;
			current = current.next;
		}
		current.next = current.next.next;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
