package com.circularlinkedlist;

import java.util.ArrayList;
import java.util.List;

import com.linkedlist.Node;

public class CircularLinkedList {
	private static Node head;
	
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.push(1);
		list.push(3);
		list.push(5);
		list.push(7);
		//list.push(1);
		/*list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		list.push(7);
		list.push(8);
		list.push(9);*/
		
		//list.displayList();
		
		/*SplitInTwoHalves split = new SplitInTwoHalves();
		List<Node> nodeList = split.spilitList(head);
		System.out.println();
		if(nodeList != null && nodeList.size() > 0){
			for(int i=0; i<nodeList.size(); i++){
				Node node = nodeList.get(i);
				Node tmp = node;
				//System.out.println(tmp.data + " " + tmp.next.data);
				do{
					System.out.print(tmp.data + " ");
					tmp = tmp.next;
				}while(tmp != node);
				System.out.println();
			}
		}*/
		
		SortedInsert sortedInsert = new SortedInsert();
		head = sortedInsert.insert(head, 6);
		
		new CircularLinkedList().displayList();
	}
	
	public void push(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			newNode.next = head;
		}else{
			Node tmp = head;
			while(tmp.next != head){
				tmp = tmp.next;
			}
			tmp.next = newNode;
			newNode.next = head;
		}
	}
	
	public void displayList(){
		if(head == null){
			System.out.println("List is empty");
		}
		Node tmp = head;
		System.out.println("Circular Linked List is:");
		
		do{
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}while(tmp != head);
		
		/*while(tmp.next != head){
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println(tmp.data);*/
	}
}
