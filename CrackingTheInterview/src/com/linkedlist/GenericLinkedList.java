package com.linkedlist;

import java.util.NoSuchElementException;
import java.util.Stack;


public class GenericLinkedList<T> {
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
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void addFirst(T item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
	}
	
	public T getFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}else {
			return first.value;
		}
	}

	
	public T getLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}else {
			return last.value;
		}
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
	
	public void add(int index, T item) {
		Node node = new Node(item);
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}else if(index == 0) {
			addFirst(item);
		}else if(index == size()) {
			addLast(item);
		}
		else {
			Node current = first;
			int currentIndex = 1;
			while(current != null && index != currentIndex) {
				current = current.next;
				currentIndex++;
			}
			node.next = current.next;
			current.next = node;
		}
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

	public int indexOf(T item) {
		int index = 0;
		Node current = first;
		while (current != null) {
			if (current.value == item) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(T item) {
		return indexOf(item) != -1;
	}

	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (first == last) {
			T value = first.value;
			first = last = null;
			return value;
		}
		T value = first.value;
		Node newNode = first.next;
		first.next = null;
		first = newNode;
		return value;
	}

	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (first == last) {
			T value = last.value;
			first = last = null;
			return value;
		}
		Node previousNode = getPreviousNode(last);
		T value = last.value;
		last = previousNode;
		last.next = null;
		return value;
	}

	public T remove(int index) {
		if (isEmpty() || index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (index == 0) {
			T value = first.value;
			removeFirst();
			return value;
		} else if (index == size() - 1) {
			T value = last.value;
			removeLast();
			return value;
		} else {
			Node current = first;
			int currentIndex = 0;
			Node prev = current;
			while (index != currentIndex) {
				prev = current;
				current = current.next;
				currentIndex++;
			}
			T value = current.value;
			prev.next = current.next;
			current.next = null;
			return value;

		}
	}

	public boolean remove(T item) {
		if (isEmpty()) {
			return false;
		}
		if (first == last) {
			if (first.value == item) {
				removeFirst();
				return true;
			} else {
				return false;
			}
		} else {
			Node current = first;
			Node prev = current;
			while (current != null) {
				if (current.value == item) {
					prev.next = current.next;
					current.next = null;
					return true;
				}
				prev = current;
				current = current.next;
			}
			return false;
		}
	}

	private Node getPreviousNode(Node node) {
		Node current = first;
		while (current != null) {
			if (current.next == node) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public T getKthElementFromLast(int index) {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (first == last) {
			if (index == 0) {
				return first.value;
			} else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		int size = size();
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int indexFromStart = size - 1 - index;
		return get(indexFromStart);
	}
	
	private Node getNodeFromItem(T item) {
		Node current = first;
		while (current != null) {
			if (current.value == item) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public void reverse() {
		if(isEmpty()) {
			System.out.println("list is empty");
			return ;
		}else if(first == last) {
			System.out.println(first.value);
			return;
		}else {
			Node prev = first;
			Node current = prev.next;
			Node nextNode = current.next;
			prev.next = null;
			current.next = prev;
			last = prev;
			while(nextNode != null) {
				prev = current;
				current = nextNode;
				nextNode = nextNode.next;
				current.next = prev;
			}
			first = current;
		}
	}
	
	public void reverseRecurrsive(){
		last = first;
		reverseRecursive(first,null);
	}
	
	private void reverseRecursive(Node current, Node prev){
		if(current == null) {
			first = prev;
			return;
		}
		Node tmp = current;
		current = current.next;
		tmp.next = prev;
		prev = tmp;
		reverseRecursive(current, prev);
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
	
	@Override
	public String toString() {
		return displayList();
	}
	
	public boolean isPalindrome() {
		if(isEmpty()) {
			System.out.println("List is empty");
			return true;
		}else if(first == last) {
			return true;
		}else {
			Stack<Node> stack = new Stack<Node>();
			Node current = first;
			while(current != null) {
				stack.add(current);
				current = current.next;
			}
			
			current = first;
			while(current != null) {
				if(current.value != stack.pop().value) {
					return false;
				}
				current = current.next;
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		GenericLinkedList<String> list = new GenericLinkedList<String>();
		list.add("alok");
		list.add("soni");
		list.add("atul");
		list.add("soni");
		
		list.reverse();
		System.out.println(list.toString());
	}
}
