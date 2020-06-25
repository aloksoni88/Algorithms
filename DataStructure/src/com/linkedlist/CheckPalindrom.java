package com.linkedlist;

import java.util.Stack;

public class CheckPalindrom {
	private Node left;
	public boolean isPalindrom(Node head){
		left = head;
		
		return checkPalindromUsingRecursion(head);
		//return checkPalindromUsingReverse(head);
		//return checkPalindromUsingStack(head);
	}
	
	
	private boolean checkPalindromUsingRecursion(Node right){
		if(right == null){
			return true;
		}
		boolean isPalindrom = checkPalindromUsingRecursion(right.next);
		System.out.println("Right " + right.data);
		if(isPalindrom){
			isPalindrom = left.data == right.data;
			left = left.next;
			return isPalindrom;
		}
		return false;
	}
	
	private boolean checkPalindromUsingStack(Node head){
		if(head == null){
			System.out.println("List is empty");
			return false;
		}
		Node tmp = head;
		Stack<Node> stack = new Stack<Node>();
		while(tmp != null){
			stack.add(tmp);
			tmp = tmp.next;
		}
		tmp = head;
		while(tmp != null){
			if(tmp.data != stack.pop().data){
				return false;
			}
			tmp = tmp.next;
		}
		return true;
	}
	
	private boolean checkPalindromUsingReverse(Node head){
		if(head == null){
			System.out.println("List is empty");
			return false;
		}else if(head.next == null){
			System.out.println("List has only 1 item so list is palindrom");
			return true;
		}
		Node fast = head;
		Node slow = head;
		Node middleNode = null;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		if(slow != null){
			middleNode = slow;
		}
		System.out.println("Middle Item is :" + middleNode.data);
		Node tmp = head;
		while(tmp != null){
			tmp = tmp.next;
			if(middleNode.data == tmp.data){
				tmp = tmp.next;
				break;
			}
		}
		Node secondHalfHead = reverseHalfList(tmp);
		Node x = secondHalfHead;
		Node firstHalfHead = head;
		while(firstHalfHead.data != middleNode.data){
			if(firstHalfHead == null || secondHalfHead == null || firstHalfHead.data != secondHalfHead.data){
				//Node reverseListNode= reverseHalfList(x);
				new CustomLinkedList().displayListRecursively(head);
				//tmp.next = reverseListNode;
				return false;
			}
			firstHalfHead = firstHalfHead.next;
			secondHalfHead = secondHalfHead.next;
		}
		
		return true;
	}
	
	private Node reverseHalfList(Node node){
		if(node == null){
			return node;
		}
		Node current = node;
		Node prev = null;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
}
