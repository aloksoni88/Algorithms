/**
 * 
 */
package com.alok.algoexpert.io.hard;

/**
 * @author Alok Soni
 *
 */
public class ReverseLinkedList {
	public static void main(String[] args) {

	}

	// Time - O(n)
	// Space - O(1)
	public static LinkedList reverseLinkedList(LinkedList head) {
		if (head == null) {
			return head;
		} else if (head.next == null) {
			return head;
		}
		LinkedList current = head;
		LinkedList prev = null;
		while (current != null) {
			LinkedList tmp = current;
			current = current.next;
			tmp.next = prev;
			prev = tmp;
		}
		head = prev;
		return head;
	}

	// reverse linked list using 2 variables
	// Time - O(n)
	// Space - O(1)
	public static LinkedList reverseLinkedList2(LinkedList head) {
		if (head == null) {
			return head;
		} else if (head.next == null) {
			return head;
		}
		LinkedList tmp = null;
		while (head != null) {
			LinkedList nextNode = head.next;
			head.next = tmp;
			tmp = head;
			head = nextNode;
		}
		head = tmp;
		return head;
	}

	// Time - O(n)
	// Space - O(n)
	public static LinkedList reverseLinkedListUsingRecursion(LinkedList head, LinkedList prev) {
		if (head == null) {
			head = prev;
			return head;
		}
		LinkedList tmp = head;
		head = head.next;
		tmp.next = prev;
		prev = tmp;
		return reverseLinkedListUsingRecursion(head, prev);
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
