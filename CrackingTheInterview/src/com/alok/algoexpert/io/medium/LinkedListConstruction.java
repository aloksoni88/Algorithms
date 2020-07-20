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
public class LinkedListConstruction {
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

		private Node getCurrentNode(Node node) {
			Node current = head;
			while (current != null && current.value != node.value) {
				current = current.next;
			}
			return current;
		}

		public void setHead(Node node) {
			// Write your code here.
			if (head == null) {
				head = tail = node;
				return;
			}
			Node current = getCurrentNode(node);
			if (current != null) {
				remove(current);
			}
			node.next = head;
			head.prev = node;
			head = node;
			head.prev = null;

		}

		public void setTail(Node node) {
			// Write your code here.
			if (tail == null) {
				head = tail = node;
				return;
			}
			Node current = getCurrentNode(node);
			if (current != null) {
				remove(current);
			}

			tail.next = node;
			node.prev = tail;
			tail = node;
			tail.next = null;
		}

		public void insertBefore(Node node, Node nodeToInsert) {
			// Write your code here.
			if (node == head) {
				nodeToInsert.next = head;
				head.prev = nodeToInsert;
				head = nodeToInsert;
				head.prev = null;
			} else {
				remove(nodeToInsert);
				Node current = getCurrentNode(node);
				if (current != null) {
					current.prev.next = nodeToInsert;
					nodeToInsert.prev = current.prev;
					current.prev = nodeToInsert;
					nodeToInsert.next = current;
				}

			}
		}

		public void insertAfter(Node node, Node nodeToInsert) {
			// Write your code here.
			Node current = getCurrentNode(node);

			if (current != null) {
				if (current == tail) {
					tail.next = nodeToInsert;
					nodeToInsert.prev = tail;
					tail = nodeToInsert;
					tail.next = null;
				} else {
					remove(nodeToInsert);
					nodeToInsert.next = current.next;
					current.next.prev = nodeToInsert;
					current.next = nodeToInsert;
					nodeToInsert.prev = current;
				}
			}
		}

		public void insertAtPosition(int position, Node nodeToInsert) {
			// Write your code here.
			if (head == null && position == 1) {
				head = tail = nodeToInsert;
				return;
			}
			Node current = head;
			int count = 1;
			while (current != null && count != position) {
				current = current.next;
				count++;
			}
			// Node nodeToRemove = getCurrentNode(nodeToInsert);
			// if(nodeToRemove != null){
			// remove(nodeToRemove);
			// }

			if (current == head) {
				nodeToInsert.next = head;
				head.prev = nodeToInsert;
				head = nodeToInsert;
			} else if (current == tail) {
				current.next = nodeToInsert;
				nodeToInsert.prev = current;
				tail = nodeToInsert;
			} else {
				current.prev.next = nodeToInsert;
				nodeToInsert.prev = current.prev;
				current.prev = nodeToInsert;
				nodeToInsert.next = current;
			}
		}

		public void removeNodesWithValue(int value) {
			// Write your code here.
			Node current = head;
			while (current != null) {
				Node nodeToDelete = current;
				current = current.next;
				if (nodeToDelete.value == value) {
					if (nodeToDelete == head) {
						head = head.next;
					} else if (nodeToDelete == tail) {
						tail = tail.prev;
						tail.next = null;
					} else {
						if (nodeToDelete != null) {
							nodeToDelete.prev.next = nodeToDelete.next;
							nodeToDelete.next.prev = nodeToDelete.prev;
						}
					}
				}

			}
		}

		public void remove(Node node) {
			// Write your code here.
			if (head == null) {
				return;
			}
			if (node == head) {
				head = head.next;
				if (head != null) {
					head.prev = null;
				}

			} else if (node == tail) {
				tail = tail.prev;
				if (tail != null) {
					tail.next = null;
				}

			} else {
				Node current = getCurrentNode(node);
				if (current != null) {
					if (current.prev != null) {
						current.prev.next = current.next;
					}
					if (current.next != null) {
						current.next.prev = current.prev;
					}
					current = null;
				}
			}

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
