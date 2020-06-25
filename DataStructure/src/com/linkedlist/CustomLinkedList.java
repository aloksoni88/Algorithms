package com.linkedlist;

public class CustomLinkedList {
	private static Node head;

	public int getCount(){
		/*if(head == null){
			return 0;
		}
		Node tmp = head;
		int counter = 0;
		while(tmp != null){
			counter++;
			tmp = tmp.next;
		}
		return counter;*/
		return getCountRecurive(head);
	}
	
	
	private int getCountRecurive(Node node){
		if(node == null){
			return 0;
		}
		
		return 1+ getCountRecurive(node.next);
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
	}
	
	public void pushAtFront(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void pushAfterGiveNodeUsingPrevNode(int prevData,int data){
		Node newNode = new Node(data);
		Node tmp = head;
		while(tmp != null && tmp.data != prevData){
			tmp = tmp.next;
		}
		if(tmp == null){
			System.out.println("We did not find node after which you want to add item");
			return;
		}
		newNode.next = tmp.next;
		tmp.next = newNode;
	}
	
	public void pushAfterGiveNode(int prevData,int data){
		
		Node tmp = head;
		Node newNode = new Node(data);
		if(tmp.data == prevData){
			newNode.next = tmp.next;
			tmp.next = newNode;
			return;
		}
		while(tmp != null && tmp.next != null && tmp.next.data != prevData){
			tmp = tmp.next;
		}
		if(tmp.next == null){
			System.out.println("We did not find node after which you want to add item");
			return;
		}
		
		newNode.next = tmp.next.next;
		tmp.next.next = newNode;
	}
	
	public void displayList(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}
		Node tmp = head;
		System.out.println("Linked List is");
		while(tmp != null){
			System.out.print(tmp.data +" ");
			tmp = tmp.next;
		}
	}
	
	public void displayListRecursively(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data + " ");
		displayListRecursively(node.next);
	}
	
	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		
		//list.pushAtFront(2);
		//list.pushAfterGiveNode(3, 4);
		//list.pushAfterGiveNodeUsingPrevNode(3, 4);
		//list.push(9);
		System.out.println("Size = " + list.getCount());
		list.displayList();
		System.out.println();
		
//		int nthItemIndex = 2;
//		int nthItem = new NthItemFromLast().nthItemFromLast(head, nthItemIndex);
//		System.out.println(nthItemIndex + " index item from last is " + nthItem);
		
//		int middleItem = new MiddleItem().middleItem(head);
//		System.out.println("Middle item is " + middleItem);
		
//		boolean isPalindrom= new CheckPalindrom().isPalindrom(head);
//		System.out.println(isPalindrom ? "List is Palindrom" : "List is not palindrom");
		
		/*Node node = new ReverseList().reverseList(head);
		list.displayListRecursively(node);*/
		
//		new RemoveDuplicateInSortedList().removeDuplicates(head);
//		list.displayList();
//		System.out.println();
		
//		Node node = new SwapNodes().swapNode(head, 4, 5);
//		list.displayListRecursively(node);
//		System.out.println();
		
//		Node node = new SwapPairNodes().swapPairNode(head);
//		list.displayListRecursively(node);
//		System.out.println();
		
		new SwapPairElement().swapPairElements(head);
		list.displayList();
		System.out.println();
	}
}
