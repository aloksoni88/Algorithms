package com.doublylinkedlist;

public class DoublyLinkedList {
	private static Node head;
	public static void main(String[] args) {
		DoublyLinkedList linkedList = new DoublyLinkedList();
		linkedList.push(8);
		linkedList.push(4);
		linkedList.push(4);
		linkedList.push(4);
		linkedList.push(6);
		linkedList.push(4);
		linkedList.push(8);
		linkedList.push(4);
		linkedList.push(10);
		linkedList.push(12);
		linkedList.push(12);
		//linkedList.displayList();
		
		System.out.println("Doubly linked list is:-");
		linkedList.displayListRecursive(head);
		
		
		/*head = new DeleteNode().deleteNode(head, 9);
		linkedList.displayList();*/
		
		/*head = new ReverseList().reverseList(head);
		System.out.println();
		linkedList.displayListRecursive(head);*/
		//linkedList.displayList();
		
		RemoveDulicates removeDulicates = new RemoveDulicates();
		head = removeDulicates.removeDuplicated(head);
		linkedList.displayList();
	}
	
	public void displayList(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		Node tmp = head;
		System.out.println("Doubly Linked List is :-");
		while(tmp != null){
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}
	
	public void displayListRecursive(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data + " ");
		displayListRecursive(node.next);
	}
	
	public void push(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return;
		}
		Node tmp = head;
		while(tmp.next != null){
			tmp = tmp.next;
		}
		tmp.next = newNode;
		newNode.prev = tmp;
	}
}
