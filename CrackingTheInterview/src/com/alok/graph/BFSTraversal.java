/**
 * 
 */
package com.alok.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Alok Soni
 *
 */
public class BFSTraversal {
	int v;
	HashMap<Integer, ArrayList<Integer>> map;
	
	public BFSTraversal(int v) {
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
	
	public void bfsTraversal(int startingVertext) {
		if(startingVertext > v) {
			System.out.println("wrong vertex, please provide correct vertext");
			return;
		}
		boolean[] visitedVertext = new boolean[v];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(startingVertext);
		ArrayList<Integer> bfsList = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int vertext = queue.poll();
			
			bfsList.add(vertext);
			visitedVertext[vertext-1] = true;
			ArrayList<Integer> adjacentVertices = map.get(vertext);
			if(adjacentVertices != null && !adjacentVertices.isEmpty()) {
				for(int v : adjacentVertices) {
					if(!visitedVertext[v-1]) {
						queue.add(v);
						visitedVertext[v-1] = true;
					}
				}
			}
		}
		
		System.out.println("BFS Traversal of given graph is : ");
		System.out.println(bfsList);
	}
	
	public static void main(String[] args) {
		BFSTraversal bfs = new BFSTraversal(9);
		bfs.addEdge(1, 2);
		bfs.addEdge(1, 4);
		bfs.addEdge(1, 5);
		
		bfs.addEdge(2, 3);
		bfs.addEdge(2, 5);
		
		bfs.addEdge(3, 6);
		
		bfs.addEdge(4, 7);
		
		bfs.addEdge(5, 6);
		bfs.addEdge(5, 8);
		
		bfs.addEdge(7, 5);
		bfs.addEdge(7, 8);
		
		bfs.addEdge(8, 9);
		
		bfs.display();
		
		bfs.bfsTraversal(6);
		
		
	}
}
