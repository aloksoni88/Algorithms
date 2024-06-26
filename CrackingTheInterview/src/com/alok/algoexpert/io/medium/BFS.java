/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Alok Soni
 *
 */
public class BFS {	
	// Do not edit the class below except
	// for the breadthFirstSearch method.
	// Feel free to add new properties
	// and methods to the class.
	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> breadthFirstSearch(List<String> array) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(this);
			while(!queue.isEmpty()) {
				Node node = queue.remove();
				array.add(node.name);
				List<Node> nodeList = node.children;
				if(nodeList != null && !nodeList.isEmpty()) {
					for(Node n : nodeList) {
						if(!queue.contains(n)) {
							queue.add(n);
						}
					}
				}
			}
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}
}
