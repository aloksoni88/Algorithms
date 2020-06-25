package com.datastructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class LinkedList2 {
	Node head;
	static int itemCount;
	public static void main(String[] args) {
		System.out.println("LinkedList creation");
		LinkedList2 list = new LinkedList2();
		list.insertAtFront(1);
		list.insertAtFront(10);
		list.insertAtFront(11);
		list.insertAtFront(12);
		list.insertAfterGivenNode(list.head, 2);
		list.insertAfterGivenNode(list.head.next, 3);
		list.insertAtFront(4);
		list.insertAtLast(5);
		list.insertAtLast(51);
		list.insertAtLast(61);
		list.insertAtLast(71);
		list.insertAtLast(81);
		list.printList();
		System.out.println();
		System.out.println("Delete head node");
		list.deleteHeadNode();
		list.printList();
		
		System.out.println();
		System.out.println("deleteing node " + 11);
	
		list.linkedListLength();
		list.deleteGivenNode(11);
		list.printList();
		System.out.println();
		list.linkedListLength();
		
		int swap1 = 5, swap2 = 1;
		System.out.println("Swapping data " + swap1 + " and " + swap2);
		list.swapNode2(swap1, swap2);
		list.printList();
	}
	
	private void insertAtFront(int data){
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	private void insertAfterGivenNode(Node givenNode, int data){
		if(givenNode == null){
			System.out.println("Given node not found");
			return;
		}
		
		Node newNode = new Node(data);
		newNode.next = givenNode.next;
		givenNode.next = newNode;
	}
	
	
	private void insertAtLast(int data){
		Node node = new Node(data);
		if(head == null){
			head = new Node(data);
			return;
		}
		
		node.next = null;
		Node last = head;
		while(last.next != null){
			last = last.next; 
		}
		last.next = node;
	}
	
	private void printList(){
		itemCount = 0;
		if(head == null){
			System.out.println("list is empty");
			return;
		}
	
		Node node = head;
		while(node != null){
			if(node.next == null){
				System.out.print(node.data);
			}else{
				System.out.print(node.data + " -> ");
			}
			node = node.next;
			itemCount++;
		}
	}
	
	private void deleteHeadNode(){
		Node tmp = head;
		if(tmp == null){
			System.out.println("List is empty");
			return;
		}
		if(tmp != null){
			tmp = tmp.next;
		}
		head = tmp;
		tmp = null;
	}
	
	private void deleteGivenNode(int data){
		boolean isDataExist=false;
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		Node prev = head;
		if(prev.data == data && prev.next != null){
			Node tmp = head;
			head = head.next;
			tmp = null;
			isDataExist = true;
			return;
		}
		Node current = head.next;
		System.out.println();
		while(current != null){
			if(current.data == data){
				Node tmp = current;
				if(current.next != null){
					prev.next = current.next;
					tmp = null;
				}else{
					tmp = null;
					prev.next = tmp;
				}
				isDataExist = true;
				return;
			}else{
				prev = current;
				current = prev.next;
			}
		}
		if(!isDataExist){
			System.out.println("Item not found");
		}
	}
	
	private void linkedListLength(){
		System.out.println("Linked List Length is : " + itemCount);
	}

	
	private void swapNode(int x, int y){
		if(head == null){
			System.out.println("List is empty");
			return;
		}else if(head != null && head.next == null){
			System.out.println("Only 1 element in list " + head.data);
			return;
		}else if(head != null && head.next != null){
			Node tmp = head;
			boolean isSwapDataAvail = false;
			Node swapNode1 = null;
			Node swapNode2 = null;
			while(tmp != null){
				if(tmp.data == x){
					swapNode1 = tmp;
				}
				else if(tmp.data == y){
					swapNode2 = tmp;
				}
				if(swapNode1 != null && swapNode2 != null){
					isSwapDataAvail = true;
					swapNode1.data = swapNode1.data + swapNode2.data;
					swapNode2.data = swapNode1.data - swapNode2.data;
					swapNode1.data = swapNode1.data - swapNode2.data;
				}
				tmp = tmp.next;
			}
			if(!isSwapDataAvail){
				System.out.println("Swapping data not available");
			}
		}else{
			System.out.println("No data found");
		}
	}
	
	private void swapNode2(int x, int y){
		if(head == null){
			System.out.println("list is empty");
		}else if(head != null && head.next == null){
			System.out.println("only 1 element is in the list");
		}else if(head != null && head.next != null){
			Node swapNode1 = null;
			Node swapNode2 = null;
			while(head != null){
				if(head.data == x){
					swapNode1 = head;
				}else if(head.data == y){
					swapNode2 = head;
				}
			}
			
			if(swapNode1 != null && swapNode2 != null){
				Node swap1Prev = null;
				Node swap2Prev = null;
				while(head != null){
					swap1Prev = head;
					if(head.next != null && head.next.data == swapNode1.data){
						break;
					}
				}
				
				while(head != null){
					swap2Prev = head;
					if(head.next != null && head.next.data == swapNode2.data){
						break;
					}
				}
				
				if(swap1Prev != null){
					swap1Prev.next = swap2Prev.next;
					swapNode1.next = swapNode2.next;
				}else{
					swap2Prev.next = swapNode1;
					swapNode2.next = swapNode1.next;
				}
				if(swap2Prev != null){
					swap2Prev.next = swap1Prev.next;
					swapNode2.next = swapNode1.next;
				}else{
					
				}
			}else{
				System.out.println("Swapping data not available");
			}
		}
	}
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
}

