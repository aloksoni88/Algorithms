/**
 * 
 */
package com.alok.graph;

import java.util.LinkedList;

/**
 * @author Alok Soni
 *
 */
public class AdjacencyListGraph {
	int v;
	LinkedList<LinkedList<Integer>> list;
	
	public AdjacencyListGraph(int v) {
		this.v = v;
		list = new LinkedList<LinkedList<Integer>>();
		for(int i=0; i<v; i++) {
			LinkedList<Integer> innerList = new LinkedList<Integer>();
			for(int j=0; j<v; j++) {
				innerList.add(0);
			}
			System.out.println(innerList);
			list.add(innerList);
		}
	}

	
	public void addEdge(int v, int e, int weight) {
		LinkedList<Integer> innerList= list.get(v-1);
		innerList.set(e-1,weight);
	}
	
	private void display() {
		for(LinkedList<Integer> l : list) {
			for(int i : l) {
				System.out.print(i + "	");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		AdjacencyListGraph graph = new AdjacencyListGraph(4);
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 4, 8);
		
		graph.addEdge(2, 1, 3);
		graph.addEdge(2, 3, 4);
		graph.addEdge(2, 4, 7);
		
		graph.addEdge(3, 4, 5);
		
		graph.addEdge(4, 1, 9);
		graph.addEdge(4, 3, 6);
		
		graph.display();
	}
}
