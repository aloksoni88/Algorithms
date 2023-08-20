package com.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyLinkedList {

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
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

	public void addFirst(int item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
	}

	public int getFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}else {
			return first.value;
		}
	}

	
	public int getLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}else {
			return last.value;
		}
	}

	
	public void addLast(int item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	public void add(int item) {
		addLast(item);
	}
	
	public void add(int index, int item) {
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

	public int get(int index) {
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

	public int indexOf(int item) {
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

	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	public int removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (first == last) {
			int value = first.value;
			first = last = null;
			return value;
		}
		int value = first.value;
		Node newNode = first.next;
		first.next = null;
		first = newNode;
		return value;
	}

	public int removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (first == last) {
			int value = last.value;
			first = last = null;
			return value;
		}
		Node previousNode = getPreviousNode(last);
		int value = last.value;
		last = previousNode;
		last.next = null;
		return value;
	}

	public int remove(int index) {
		if (isEmpty() || index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (index == 0) {
			int value = first.value;
			removeFirst();
			return value;
		} else if (index == size() - 1) {
			int value = last.value;
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
			int value = current.value;
			prev.next = current.next;
			current.next = null;
			return value;

		}
	}

	public boolean remove(Integer item) {
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

	public MyLinkedList removeDuplicates(MyLinkedList list) {
		if (isEmpty()) {
			System.out.println("List is empty");
			return list;
		}
		if (first == last) {
			System.out.println("List has only 1 item");
			return list;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node current = first;
		Node prev = current;
		set.add(current.value);
		while (current != null) {
			prev = current;
			current = current.next;
			if (current != null) {
				if (set.contains(current.value)) {
					prev.next = current.next;
					current.next = null;
					current = prev.next;
				} else {
					set.add(current.value);
				}
			}
		}
		return list;
	}

	public int getKthElementFromLast(int index) {
		if (isEmpty()) {
			return -1;
		} else if (index < 0) {
			return -1;
		} else if (first == last) {
			if (index == 0) {
				return first.value;
			} else {
				return -1;
			}
		}
		int size = size();
		if (index >= size) {
			return -1;
		}
		int indexFromStart = size - 1 - index;
		return get(indexFromStart);
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

	public MyLinkedList deleteMidWithoutHead(MyLinkedList list, int item) {
		if (isEmpty()) {
			return list;
		} else if (first == last) {
			if (first.value == item) {
				first = last = null;
				return null;
			} else {
				return list;
			}
		} else {
			Node node = getNodeFromItem(item);
			if (node != null) {
				deleteMidWithoutHead(node);
				return list;
			} else {
				return list;
			}
		}
	}

	public void deleteMidWithoutHead(Node nodeToBeDeleted) {
		if (nodeToBeDeleted.next == null) {
			nodeToBeDeleted = null;
			return;
		} else {
			nodeToBeDeleted.value = nodeToBeDeleted.next.value;
			nodeToBeDeleted.next = nodeToBeDeleted.next.next;
		}
	}

	private Node getNodeFromItem(int item) {
		Node current = first;
		while (current != null) {
			if (current.value == item) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public void partition(int item) {
		if (isEmpty()) {
			System.out.println("list is empty");
			return;
		} else if (first == last) {
			System.out.println("List has only i item..");
			return ;
		}
		
		Node current = first;
		int value = first.value;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		//just to test
		while (current != null) {
			arrayList.add(current.value);
			current = current.next;
		}
		first = null;
		
		for(int i : arrayList) {
			addItemToPartitionList(i , item);
		}
	}
	
	public Node partitionOptimize(Node head, int item) {
		Node less_head = null, less_last = null;
		Node equal_head = null, equal_last = null;
		Node greater_head = null, greater_last = null;
		
		Node current = head;
		Node nextNode;
		while (current != null) {
			nextNode = current.next;
			if (current.value < item) {
				if (less_head == null) {
					less_head = current;
					less_last = less_head;
					less_last.next = null;
				} else {
					less_last.next = current;
					less_last =  less_last.next;
					less_last.next = null;
				}
			} else if(current.value == item) {
				if (equal_head == null) {
					equal_head = current;
					equal_last = equal_head;
					equal_last.next = null;
				} else {
					equal_last.next = current;
					equal_last = equal_last.next;
					equal_last.next = null;
				}
			} else {
				if (greater_head == null) {
					greater_head = current;
					greater_last = greater_head;
					greater_last.next = null;
				} else {
					greater_last.next = current;
					greater_last = greater_last.next;
					greater_last.next = null;
				}
			}
			current = nextNode;
		}
		if (less_head == null) {
			if (equal_head == null) {
				return greater_head;
			}
			equal_last.next = greater_head;
			return equal_head;
		}
		
		if (equal_head == null) {
			less_last.next = greater_head;
			return less_head;
		}
		
		less_last.next = equal_head;
		equal_last.next = greater_head;
		return less_head;
		
	}

	private void addItemToPartitionList(int item, int partitionValue) {
		Node current = first;
		int index =0;
		if(item > partitionValue) {
			addLast(item);
			return;
		}
		while(current != null && item > current.value ) {
			index++;
			current = current.next;
		}
//		System.out.println("Index " + index + " for item " + item);
		if(index == size()) {
			addLast(item);
			return;
		}
		add(index,item);
		//System.out.println(displayList());
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
	
	public void reverseUsing2Variable() {
		if(isEmpty()) {
			System.out.println("list is empty");
			return ;
		}else if(first == last) {
			System.out.println(first.value);
			return;
		}else {
			Node current = first;
			Node prev = null;
			last = current;
			while(current != null) {
				Node tmp = current;
				current = current.next;
				tmp.next = prev;
				prev = tmp;
			}
			first = prev;

		}
	}
	
	public void reverseUsingStack() {
		if(isEmpty()) {
			System.out.println("list is empty");
			return ;
		}else if(first == last) {
			System.out.println(first.value);
			return;
		}else {
			Stack<Node> stack = new Stack<Node>();
			Node current = first;
			while(current != null) {
				stack.add(current);
				current = current.next;
			}
			
			first = stack.pop();
			current = first;
			while(!stack.isEmpty()) {
				current.next = stack.pop();
				current = current.next;
			}
			current.next = null;
			last = current;
		}
	}
	
	public void reverseRecurrsively() {
		last = first;
		recurrsiveReverse(first, null);
	}
	
	private void recurrsiveReverse(Node current, Node prev) {
		if(current == null) {
			first = prev;
			return;
		}
		Node tmp = current;
		current = current.next;
		tmp.next = prev;
		prev= tmp;
		recurrsiveReverse(current, prev);
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addFirst(1);
		list.addLast(4);
		list.addLast(3);
		list.add(2);
		list.add(5);
		list.addLast(2);
		list.addLast(3);

		System.out.println(list.toString());
		System.out.println(list.first);
		Node head = list.partitionOptimize(list.first, 3);
		
		Node current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		list.displayList();
		
	}
}
