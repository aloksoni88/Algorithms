/**
 * 
 */
package com.alok.algoexpert.io.veryhard;

/**
 * @author Alok Soni
 *
 */
public class LinkedListPalindrome {
	private static LinkedList left;
	public static void main(String[] args) {
		LinkedList head = new LinkedList(0);
		head.next = new LinkedList(1);
		head.next.next = new LinkedList(2);
		head.next.next.next = new LinkedList(2);
		head.next.next.next.next = new LinkedList(1);
		head.next.next.next.next.next= new LinkedList(0);
		boolean isPalindrome = linkedListPalindrome(head);
		System.out.println(isPalindrome);
	}
	
	//Time - O(n) , Space - O(1) where n is the length of the node
	public static boolean linkedListPalindrome(LinkedList head) {
		if (head.next == null) {
			return true;
		}
		LinkedList slow = head;
		LinkedList fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;			
		}
		LinkedList secondHalfHead = reverseLinkedList(slow);
		LinkedList firstHalfHead = head;
		while(secondHalfHead != null) {
			if(firstHalfHead.value != secondHalfHead.value) {
				return false;
			}
			firstHalfHead = firstHalfHead.next;
			secondHalfHead = secondHalfHead.next;
		}
		return true;
	}
	
	private static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList prev = null, current = head;		
		while(current != null) {
			LinkedList tmp = current;
			current = current.next;
			tmp.next = prev;
			prev = tmp;
		}
		head = prev;
		return head;
	}
	
	//Time - O(n) , Space - O(n) where n is the length of the node
	public static boolean linkedListPalindrome2(LinkedList head) {
		if (head.next == null) {
			return true;
		}
		left = head;
		return isPalindrome(head);
	}
	
	private static boolean isPalindrome(LinkedList right) {
		if(right == null) {
			return true;
		}
		boolean isPalindrome = isPalindrome(right.next);
		if(isPalindrome) {
			isPalindrome = left.value == right.value;
			left = left.next;
			return isPalindrome;
		}
		return false;
	}

	// This is an input class. Do not edit.
	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}
}
