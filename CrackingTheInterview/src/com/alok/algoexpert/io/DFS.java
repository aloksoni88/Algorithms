/**
 * 
 */
package com.alok.algoexpert.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class DFS {
	 static class Node {
		    String name;
		    List<Node> children = new ArrayList<Node>();

		    public Node(String name) {
		      this.name = name;
		    }

		    public List<String> depthFirstSearch(List<String> array) {
		      if(children == null){
						return null;
					}
					return depthFirstSearchAlgo(array);
		    }
				
				private  List<String> depthFirstSearchAlgo(List<String> array){
						Stack<Node> stack = new Stack<Node>();
						stack.push(this);
						while(!stack.isEmpty()){
							 Node node = stack.pop();
							 if(!array.contains(node.name)){
									array.add(node.name); 
							 }
							 List<Node> childrens = node.children;
							 if(childrens != null && !childrens.isEmpty()){
									for(int i=childrens.size()-1; i>=0; i--){
											Node child = childrens.get(i);
											stack.push(child);
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
