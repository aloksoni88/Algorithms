/**
 * 
 */
package com.alok.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
public class DFSTraversal {
	int v;
	HashMap<Integer, ArrayList<Integer>> map;
	
	public DFSTraversal(int v) {
		this.v = v;
		map = new HashMap<Integer, ArrayList<Integer>>();
	}
	
	public void addEdge(int v, int e) {
		if(map.containsKey(v)) {
			map.get(v).add(e);
		}else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(e);
			map.put(v,list);
		}
	}
	
	public void display() {
		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			int key = entry.getKey();
			for(int i : entry.getValue()) {
				System.out.print(key + "->" + i + ", ");
			}
			System.out.println();
		}
	}
	
	public void dfsTraversal(int startingVertext) {
		if(startingVertext > v) {
			System.out.println("wrong vertex, please provide correct vertext");
			return;
		}
		ArrayList<Integer> dfsList = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(startingVertext);
		while(!stack.isEmpty()) {
			int vertext = stack.pop();
			
			if(!dfsList.contains(vertext)) {
				dfsList.add(vertext);	
			}
			ArrayList<Integer> verticesList = map.get(vertext);
			if(verticesList != null && !verticesList.isEmpty()) {
				for(int i= verticesList.size()-1; i>=0; i--) {
					stack.push(verticesList.get(i));
				}
			}
		}
		System.out.println("DFS Traversal of given graph is : ");
		System.out.println(dfsList);
	}
	
	public static void main(String[] args) {
		DFSTraversal dfs = new DFSTraversal(9);
		dfs.addEdge(1, 2);
		dfs.addEdge(1, 4);
		dfs.addEdge(1, 5);
		
		dfs.addEdge(2, 3);
		dfs.addEdge(2, 5);
		
		dfs.addEdge(3, 6);
		
		dfs.addEdge(4, 7);
		
		dfs.addEdge(5, 6);
		dfs.addEdge(5, 8);
		
		dfs.addEdge(7, 5);
		dfs.addEdge(7, 8);
		
		dfs.addEdge(8, 9);
		
		dfs.display();
		
		dfs.dfsTraversal(1);
	}
}
