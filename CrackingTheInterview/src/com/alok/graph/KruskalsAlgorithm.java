/**
 * 
 */
package com.alok.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

/**
 * @author Alok Soni
 *
 */
public class KruskalsAlgorithm {
	private int[][]arr;
	public KruskalsAlgorithm(int size) {
		this.size = size;
		arr = new int[size][size];
	}
	private HashSet<Node> nodeHashSet = new HashSet<Node>();
	
	private HashMap<Integer, Integer> treeMap = new HashMap<Integer, Integer>();
	private int size;
	private class Node{
		private int src;
		private int dest;
		private int weight;
		
		public Node(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Node) {
				if(src == ((Node)obj).dest && dest == ((Node)obj).src) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return (src+dest);
		}
		
		@Override
		public String toString() {
			if(zerothElement) {
				return src + "->" + dest + "=" + weight;
			}
			return (src+1) + "->" + (dest+1) + "=" + weight; 
		}
	}
	
	private boolean zerothElement = false;
	
	public void addEdge(int src, int dest, int weight) {
		src = zerothElement ? src : src-1;
		dest = zerothElement ? dest : dest-1;
		arr[src][dest] = weight;
		nodeHashSet.add(new Node(src, dest, weight));
	}
	
	public void display() {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j] != 0) {
					System.out.print((i+1) + "->" + (j+1) +"="+arr[i][j] + ", ");
				}
			}
			System.out.println();
		}
	}
	
	public void KruskalsAlgorithm() {
		System.out.println("After sorting node ");
		ArrayList<Node> nodeList = new ArrayList<Node>(nodeHashSet);
		Collections.sort(nodeList,new Comparator<Node>() {
			@Override
			public int compare(Node node1, Node node2) {
				return node1.weight - node2.weight;
			}
		});
		System.out.println(nodeList);
	
		for(int i=0; i<size; i++) {
			if(zerothElement) {
				treeMap.put(i, 0);
			}else {
				treeMap.put(i+1, 0);
			}
		}
		System.out.println(treeMap);
		
		ArrayList<Node> minimumSpanningTree = new ArrayList<Node>();
		for(int i=0; i<nodeList.size(); i++) {
			Node node = nodeList.get(i);
			int src = zerothElement ? node.src : node.src+1;
			int dest = zerothElement ? node.dest :node.dest+1;
			int node_src = treeMap.get(src);
			if(node_src == 0) {
				node_src = src;
			}else {
				while(treeMap.get(node_src) != 0) {
					node_src = treeMap.get(node_src); 
				}
			}
			
			int node_dest = treeMap.get(dest);
			if(node_dest == 0) {
				node_dest = dest;
			}else {
				while(treeMap.get(node_dest) != 0) {
					node_dest = treeMap.get(node_dest);
				}
			}
			
			
			if(node_src != node_dest) {
				treeMap.put(node_dest, node_src);
				minimumSpanningTree.add(node);
			}
			
		}
		int treeLength = 0;
		for(int i=0; i<minimumSpanningTree.size(); i++) {
			Node node =minimumSpanningTree.get(i);
			treeLength = treeLength + node.weight;
		}
		System.out.println(treeMap);
		System.out.println("Minimum spanning tree length = " + treeLength);
		
	}
	
	public static void main(String[] args) {
		KruskalsAlgorithm algo = new KruskalsAlgorithm(9);
		
		algo.addEdge(1, 2, 9);
		algo.addEdge(1, 4, 4);
		algo.addEdge(1, 5, 2);
		
		algo.addEdge(2, 1, 9);
		algo.addEdge(2, 3, 10);
		algo.addEdge(2, 5, 8);
		
		algo.addEdge(3, 2, 10);
		algo.addEdge(3, 5, 7);
		algo.addEdge(3, 6, 5);
		
		algo.addEdge(4, 1, 4);
		algo.addEdge(4, 5, 3);
		algo.addEdge(4, 7, 18);
		
		algo.addEdge(5, 1, 2);
		algo.addEdge(5, 2, 8);
		algo.addEdge(5, 3, 7);
		algo.addEdge(5, 4, 3);
		algo.addEdge(5, 6, 6);
		algo.addEdge(5, 7, 11);
		algo.addEdge(5, 8, 12);
		algo.addEdge(5, 9, 15);
		
		algo.addEdge(6, 3, 5);
		algo.addEdge(6, 5, 6);
		algo.addEdge(6, 9, 16);
		
		algo.addEdge(7, 4, 18);
		algo.addEdge(7, 5, 11);
		algo.addEdge(7, 8, 14);
		
		algo.addEdge(8, 5, 12);
		algo.addEdge(8, 7, 14);
		algo.addEdge(8, 9, 20);
		
		algo.addEdge(9, 5, 15);
		algo.addEdge(9, 6, 16);
		algo.addEdge(9, 8, 20);
		
		algo.display();
		algo.KruskalsAlgorithm();
	}
	
	
}
