/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alok Soni
 *
 */
public class FindLoop {
	public static void main(String[] args) {

	}

	// Time - O(n)
	// Space - O(1)
	public static LinkedList findLoopOptimize(LinkedList head) {
		LinkedList current = head;
		LinkedList fast = head;
		while (current != null && current.next != null) {
			current = current.next;
			fast = fast.next.next;
			if (current == null) {
				return null;
			}
			if (current == fast) {
				break;
			}
		}
		current = head;
		while (current != fast) {
			current = current.next;
			fast = fast.next;
		}
		return current;
	}

	// Time - O(n)
	// Space - O(n)
	public static LinkedList findLoop(LinkedList head) {
		if (head == null) {
			return head;
		}
		LinkedList current = head;
		Set<LinkedList> set = new HashSet<>();
		while (current != null) {
			if (!set.contains(current)) {
				set.add(current);
			} else {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
