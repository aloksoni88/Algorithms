package com.datastructure;

import java.util.LinkedList;

public class CustomLinkedList {
	Node head;
	private transient int size = 0;
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	private boolean isEmpty(){
		return size() == 0;
	}
	
	private int size(){
		return size;
	}
	/**
	 * Insert at last
	 * @param data - data to be inserted
	 */
	private void insertElement(int data){
		Node newNode = new Node(data);
		newNode.next = null;
		
		if(head == null){
			head = newNode;
		}else{
			Node last = head;
			while(last.next != null){
				last = last.next;
			}
			last.next = newNode;
		}
		size++;
	}
	
	private void insertAtFirst(int data){
		Node new_node = new Node(data);
		new_node.next = null;
		
		if(head == null){
			head = new_node;
		}else{
			new_node.next = head;
			head = new_node;
		}
		size++;
	}
	
	private void insertAtIndex(int index, int data){
		if((head == null || isEmpty()) && index > 0){
			System.out.println("List is empty and given index is given out of bound");
		}else if(index > size()){
			System.out.println("Size is out of bound");
		}else{
			int count = 0;
			if(index == 0){
				insertAtFirst(data);
			}else if(index == size()){
				insertElement(data);
			}else{
				
				Node currentNode = head;
				while(currentNode != null){
					if(count == index-1){
						Node new_node = new Node(data);
						new_node.next = currentNode.next;
						currentNode.next = new_node;
					}
					
					currentNode = currentNode.next;
					count++;	
				}	
				size++;
			}
		}
	}
	
	private void deleteFirstElement(){
		if(head == null || isEmpty()){
			System.out.println("List is empty, no data to be deleted");
		}
		else{
			head = head.next;
			size--;
		}
	}
	
	private void deleteLastElement(){
		if(head == null || isEmpty()){
			System.out.println("List is empty, no data to be deleted");
		}
		else{
			Node currentNode = head;
			while(currentNode.next.next != null){
				currentNode = currentNode.next;
			}
			currentNode.next = null;
			size--;
		}
	}
	
	private void deleteAtPosition(int position){
		if(head == null || isEmpty()){
			System.out.println("List is empty, no data to be deleted");
		}else if(position > size()-1){
			System.out.println("Given index is out of bound");
		}else if(position == 0){
			deleteFirstElement();
		}else if(position == size()-1){
			deleteLastElement();
		}else{
			int count=0;
			Node currentNode = head;
			Node prev = null;
			while(currentNode != null){
				if(count == position){
					prev.next = currentNode.next;
					break;
				}
				prev = currentNode;
				currentNode = currentNode.next;
				count++;
			}
			size--;
		}
	}
	
	private void printList(){
		if(head == null || isEmpty()){
			System.out.println("List is empty");
		}else {
			Node node = head;
			if(node != null){
				while(node != null){
					System.out.print(node.data + " ");
					node = node.next;
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		/*LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(5);
		list.add(6);
		list.add(2);*/
		CustomLinkedList customList = new CustomLinkedList();
		customList.insertElement(5);
		customList.insertElement(4);
		customList.insertElement(4);
		customList.insertElement(7);
		customList.insertAtFirst(9);
		System.out.println(customList.size());
		customList.printList();
		customList.insertAtIndex(1, 11);
		customList.printList();
		System.out.println("After deleting first element");
		customList.deleteFirstElement();
		System.out.println(customList.size());
		customList.printList();
		System.out.println("After deleting last element");
		customList.deleteLastElement();
		System.out.println(customList.size());
		customList.printList();
		System.out.println("After deleting at position");
		customList.deleteAtPosition(1);
		customList.printList();
		
	}
}
