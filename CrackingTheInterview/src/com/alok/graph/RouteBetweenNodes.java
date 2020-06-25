/**
 * 
 */
package com.alok.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
/**
 * Question
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
	route between two nodes.
	https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
 * 
 */
public class RouteBetweenNodes {
	private HashMap<Integer, ArrayList<Integer>> map;
	
	public RouteBetweenNodes(int size) {
		map = new HashMap<Integer, ArrayList<Integer>>();
	}
	private void addEdge(int src, int dest) {
		ArrayList<Integer> vList = new ArrayList<Integer>();
		if(map.containsKey(src)) {
			vList= map.get(src);
		}
		vList.add(dest);
		map.put(src, vList);
	}
	
	public ArrayList<Integer> checkPath(int startVertext, int endVertext) {
		if(!map.containsKey(startVertext) && !map.containsKey(endVertext)) {
			System.out.println("No path exist from "+startVertext + " to " + endVertext);
			return null;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startVertext);
		ArrayList<Integer> pathList = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int vertext = queue.remove();
			if(!pathList.contains(vertext)) {
				pathList.add(vertext);
				if(vertext == endVertext) { 	
					return pathList;
				}
				ArrayList<Integer> adjacentList = map.get(vertext);
				if(adjacentList != null) {
					for(int i=adjacentList.size()-1; i>=0; i--) {
						if(vertext != adjacentList.get(i) && !queue.contains(vertext)) {
							queue.add(adjacentList.get(i));
						}
					}
				}
			}
		}
		
		System.out.println("No path exist from "+startVertext + " to " + endVertext);
		return null;
	}
	
	public static void main(String[] args) {
		RouteBetweenNodes route = new RouteBetweenNodes(4);
		
		route.addEdge(0, 1);
		route.addEdge(0, 2);
		
		route.addEdge(1, 2);
		
		route.addEdge(2, 0);
		route.addEdge(2, 3);
		
		route.addEdge(3, 3);
		
		ArrayList<Integer> list = route.checkPath(0, 3);
		if(list != null) {
			System.out.println(list);
		}
	}
}
