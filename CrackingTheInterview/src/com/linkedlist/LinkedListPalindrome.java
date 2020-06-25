package com.linkedlist;

public class LinkedListPalindrome<T> {
	
	private class Node {
		private T value;
		private Node next;

		public Node(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node Value : " + value;
		}
	}
	private Node first;
	private Node last;
	private Node first_secondHalf;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void addLast(T item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}
	
	public void add(T item) {
		addLast(item);
	}
	
	public T get(int index) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			return first.value;
		} else if (index == size() - 1) {
			return last.value;
		} else {
			int currentIndex = 0;
			Node current = first;
			while (index != currentIndex) {
				current = current.next;
				currentIndex++;
			}
			return current.value;
		}
	}
	
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		if (first == last) {
			return 1;
		}
		Node current = first;
		int index = 0;
		while (current != null) {
			current = current.next;
			index++;
		}
		return index;
	}
	
	private String displayList() {
		if (isEmpty()) {
			return "[]";
		} else if (first == last) {
			return "[" + first.value + "]";
		} else {
			String str = "[";
			Node current = first;
			while (current != null) {
				str = str + current.value + ", ";
				current = current.next;
			}
			str = str.trim().substring(0, str.length() - 2);
			str = str + "]";
			return str;
		}
	}
	
	private String displaySecondHalfList() {
		if (first_secondHalf == null) {
			return "[]";
		} else if (first_secondHalf == last) {
			return "[" + first_secondHalf.value + "]";
		} else {
			String str = "[";
			Node current = first_secondHalf;
			while (current != null) {
				str = str + current.value + ", ";
				current = current.next;
			}
			str = str.trim().substring(0, str.length() - 2);
			str = str + "]";
			return str;
		}
	}
	
	@Override
	public String toString() {
		return displayList();
	}
	
	
	public boolean isPalindromeUsingReverse() {
		if(isEmpty()) {
			System.out.println("List is empty");
			return true;
		}else if(first == last) {
			return true;
		}else {
			Node current = first;
			Node fast = current.next;
			Node midNode = null;
			boolean isPalindrome = true;
			if(fast != null && fast.next != null) {
				while(fast != null && fast.next != null) {
					fast = fast.next.next;
					current = current.next;
				}
				
				if(fast == null) {
					System.out.println("fast is  null");
					midNode = current;
//					current = current.next;
				}
				reverseOfSecondHalf(current.next);
				System.out.println(displaySecondHalfList());
				
				Node newCurrent = first;
				Node secHalfCurrent = first_secondHalf;
				while(secHalfCurrent != null) {
					if(newCurrent.value != secHalfCurrent.value) {
						isPalindrome = false;
						break;
					}
					newCurrent = newCurrent.next;
					secHalfCurrent = secHalfCurrent.next;
				}
			}
			reverseOfSecondHalf(first_secondHalf);
			System.out.println(displaySecondHalfList());
			if(fast == null) {
				current.next = midNode;
				midNode.next = first_secondHalf;
			}else {
				current.next = first_secondHalf;
			}
			return isPalindrome;
		}
	}
	
	private boolean checkPalindromeUsingRecurrsion() {
		return isPalindrome(first);
	}
	
	Node left = null;
	private boolean isPalindrome(Node right) {
		left = first;
		if(right == null) {
			return true;
		}

		boolean isPal = isPalindrome(right.next);
		if(!isPal) {
			return false;
		}
		if(right.value != left.value) {
			return false;
		}
		left = left.next;
		return true;
	}
	
	private void reverseOfSecondHalf(Node head) {
		first_secondHalf = head;
		if(first_secondHalf == last) {
			return;
		}else {
			Node current = first_secondHalf;
			Node prev = null;
			last = current;
			while(current != null) {
				Node tmp = current;
				current = current.next;
				tmp.next = prev;
				prev = tmp;
			}
			first_secondHalf = prev;
		}
	}

	
	public static void main(String[] args) {
//		LinkedListPalindrome<Integer> list = new LinkedListPalindrome<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(1);
//		list.add(2);
//		list.add(2);
//		
//		GenericLinkedList<Integer> list2 = new GenericLinkedList<Integer>();
//		list2.add(1);
//		list2.add(2);
//		list2.add(1);
//		list2.add(2);
//		list2.add(2);
//		
//		list2.reverseRecurrsive();
//		boolean isPalindrome = true;
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i) != list2.get(i)) {
//				isPalindrome = false;
//				break;
//			}
//		}
//		if(isPalindrome) {
//			System.out.println("list is palindrome");
//		}else {
//			System.out.println("List is not palindrome");
//		}
		
		LinkedListPalindrome<Character> list = new LinkedListPalindrome<Character>();
		list.add('A');
		list.add('B');
		list.add('C');
		list.add('D');
		list.add('D');
		list.add('C');
		list.add('B');
		list.add('A');
//		boolean isPanlindrome = list.isPalindromeUsingReverse();
		boolean isPanlindrome = list.checkPalindromeUsingRecurrsion();
		if(isPanlindrome) {
			System.out.println("List is palindrome");
		}else {
			System.out.println("List is not a palindrome");
		}
	}
}
