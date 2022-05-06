/**
 * 
 */
package com.alok.algoexpert.io.hard;

/**
 * @author Alok Soni
 *
 */
public class MergeLinkedList {
	public static void main(String[] args) {
			LinkedList list = new LinkedList(2);
			list.next = new LinkedList(3);
			list.next.next = new LinkedList(4);
			list.next.next.next = new LinkedList(6);
			
			LinkedList list2 = new LinkedList(1);
			list2.next = new LinkedList(5);
			list2.next.next = new LinkedList(7);
			
			LinkedList mergedList = mergeLinkedListsInPlace(list, list2);
			LinkedList current = mergedList;
			while(current != null) {
				System.out.print(current.value + "->");
				current = current.next;
			}
	}

	// This is an input class. Do not edit.
	public static class LinkedList {
		int value;
		LinkedList next;

		LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	//below solution will create an new linkedlist
	//Time - O(n)
	//Space - O(1)
	public static LinkedList mergeLinkedListsInPlace(LinkedList headOne, LinkedList headTwo) {
		if(headOne == null && headTwo == null) {
			return null;
		}
		
		LinkedList p1 = headOne;
		LinkedList p2 = headTwo;
		LinkedList prev = null;
		while(p1 != null && p2 != null){
				if(p1.value < p2.value){
						prev = p1;
						p1 = p1.next;
				}else{
						if(prev != null){
								prev.next = p2;
						}
						prev = p2;
						p2 = p2.next;
						prev.next = p1;
				}
		}
		if(p1 == null){
				prev.next = p2;
		}
		return headOne.value < headTwo.value ? headOne : headTwo;
	}
	
	//below solution will create an new linkedlist
	//Time - O(n)
	//Space - O(n)
	public static LinkedList mergeLinkedListsRecursive(LinkedList headOne, LinkedList headTwo) {
		if(headOne == null && headTwo == null) {
			return null;
		}
		mergeLinkedListsRecursive(headOne, headTwo, null);
		return headOne.value < headTwo.value ? headOne : headTwo;
	}
	
	private static void mergeLinkedListsRecursive(LinkedList p1, LinkedList p2, LinkedList prev){
			if(p1 == null || p2 == null){
					if(p1 == null){
							prev.next = p2;
					}
					return;
			}
			if(p1.value < p2.value){
					prev = p1;
					p1 = p1.next;
			}else{
					if(prev != null){
							prev.next = p2;
					}
					prev = p2;
					p2 = p2.next;
					prev.next = p1;
			}
			mergeLinkedListsRecursive(p1,p2,prev);
	}
	

	//below solution will create an new linkedlist
	//Time - O(n)
	//Space - O(n)
	public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
		if(headOne == null && headTwo == null) {
			return null;
		}
		LinkedList currentOne = headOne;
		LinkedList currentTwo = headTwo;
		LinkedList head = null;
		LinkedList current = null;
		while(currentOne != null && currentTwo != null) {
			LinkedList newNode;
			if(currentOne.value < currentTwo.value) {
				newNode = new LinkedList(currentOne.value);
				currentOne = currentOne.next;
			}else {
				newNode = new LinkedList(currentTwo.value);
				currentTwo = currentTwo.next;
			}
			if(current == null) {
				head = newNode;
				current = head;
			}else {
				current.next = newNode;
				current = newNode;
			}
		}
		while(currentOne != null) {
			LinkedList newNode = new LinkedList(currentOne.value);
			current.next= newNode;
			current = newNode;
			currentOne = currentOne.next;
		}
		while(currentTwo != null) {
			LinkedList newNode = new LinkedList(currentTwo.value);
			current.next= newNode;
			current = newNode;
			currentTwo = currentTwo.next;
		}
		return head;
	}
}
