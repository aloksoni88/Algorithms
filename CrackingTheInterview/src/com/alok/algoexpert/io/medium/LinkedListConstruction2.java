/**
 * 
 */
package com.alok.algoexpert.io.medium;

/**
 * @author Alok Soni
 * 
 *         For question please follow below link
 *         file:///Users/unifytechnologies/MyStuff/MyGit/Algorithms/CrackingTheInterview/AlgoExpert.io_problems/medium/LinkedListConstruction.png
 */
public class LinkedListConstruction2 {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.setHead(new Node(1));
		list.insertAfter(new Node(1), new Node(2));
		list.insertAfter(new Node(2), new Node(3));
		list.insertAfter(new Node(3), new Node(4));
		System.out.println(list);
		list.insertAfter(new Node(2), new Node(1));
		System.out.println(list);
		list.insertBefore(new Node(3), new Node(4));
		System.out.println(list);

//		list.setHead(new Node(5));
//		list.setHead(new Node(4));
//		list.setHead(new Node(3));
//		list.setHead(new Node(2));
//		list.setHead(new Node(1));
//		list.setHead(new Node(4));
//		list.setTail(new Node(6));
//		System.out.println(list);
//		list.insertBefore(new Node(6), new Node(3));
//		System.out.println("insertBefore(6,3)="+list);
//		list.insertAfter(new Node(6), new Node(3));
//		System.out.println("insertAfter(6,3)="+list);
//		list.insertAtPosition(1, new Node(3));
//		System.out.println("insertAtPosition(1,3)="+list);
//		list.insertAtPosition(8, new Node(8));
//		System.out.println("insertAtPosition(9,8)="+list);
//		list.removeNodesWithValue(3);
//		System.out.println("removeNodesWithValue(3)=" + list);
//		list.remove(new Node(2));
//		System.out.println("remove(2)=" + list);
		System.out.println(list.head.value + " " + list.tail.value);
	}

	static class DoublyLinkedList {
		public Node head;
		public Node tail;

		public void setHead(Node node) {
			if (head == null) {
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
		}

		public void setTail(Node node) {
			if (tail == null) {
				setHead(node);
				return;
			}
			insertAfter(tail, node);
		}

		public void insertBefore(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail) {
				return;
			}
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if (node.prev != null) {
				node.prev.next = nodeToInsert;
			} else {
				head = nodeToInsert;
			}
			node.prev = nodeToInsert;
		}

		public void insertAfter(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail) {
				return;
			}
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;
			if (node.next != null) {
				node.next.prev = nodeToInsert;
			} else {
				tail = nodeToInsert;
			}
			node.next = nodeToInsert;
		}

		public void insertAtPosition(int position, Node nodeToInsert) {
			if (position == 1) {
				setHead(nodeToInsert);
			} else {
				Node current = head;
				int count = 1;
				while (current != null && count != position) {
					current = current.next;
					count++;
				}
				if (current == null) {
					setTail(nodeToInsert);
				} else {
					insertBefore(current, nodeToInsert);
				}
			}
		}

		public void removeNodesWithValue(int value) {
			Node current = head;
			while (current != null) {
				Node delNode = current;
				current = current.next;
				if (delNode.value == value) {
					remove(delNode);
				}

			}
		}

		public void remove(Node node) {
			if (node == head) {
				head = head.next;
			}
			if (node == tail) {
				tail = tail.prev;
			}
			if (node.prev != null) {
				node.prev.next = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			}
			node.next = null;
			node.prev = null;
		}

		public boolean containsNodeWithValue(int value) {
			Node current = head;
			while (current != null) {
				if (current.value == value) {
					return true;
				}
				current = current.next;
			}
			return false;
		}
	}

	// Do not edit the class below.
	static class Node {
		public int value;
		public Node prev;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}
}
