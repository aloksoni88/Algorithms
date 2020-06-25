/**
 * 
 */
package com.alok.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alok Soni
 *
 */
public class DijkstrasAlgorithm {
	private boolean zerothElement = false;
	private enum Status{
		temp,perm
	}
	
	private class Node{
		private int name;
		private int dist;
		private Status status;
		private int pred;
		
		public Node() {
			
		}
		public Node(int name, int dist, Status status, int pred) {
			this.name = name;
			this.dist = dist;
			this.status = status;
			this.pred = pred;
		}
		
		
		
		public int getName() {
			return name;
		}
		public void setName(int name) {
			this.name = name;
		}
		public int getDist() {
			return dist;
		}
		public void setDist(int dist) {
			this.dist = dist;
		}
		public Status getStatus() {
			return status;
		}
		public void setStatus(Status status) {
			this.status = status;
		}
		public int getPred() {
			return pred;
		}
		public void setPred(int pred) {
			this.pred = pred;
		}
		@Override
		public String toString() {
			return name + "	"+ dist + "	" + status.toString() + "	"+ pred+"\n";
		}
	}
	
	private int[][] arr;
	private HashMap<Integer, ArrayList<Integer>> map;
	private Node[] node;
	
	public DijkstrasAlgorithm(int size) {
		arr = new int[size][size];
		map = new HashMap<Integer, ArrayList<Integer>>();
		node = new Node[size];
		for(int i=0; i<size; i++) {
			node[i] = new Node(i, Integer.MAX_VALUE, Status.temp, -1);
		}
		System.out.println("Node" + "	" + "Dist" + "	" + "Status" + "	" + "Pred");
		System.out.println(Arrays.toString(node));
	}
	public void isOthElementThere(boolean zerothElement) {
		this.zerothElement = zerothElement; 
	}
	
	public void addEdge(int src, int dest, int weight) {
		src = zerothElement ? src : src-1;
		dest = zerothElement ? dest : dest-1;
		arr[src][dest] = weight;
		if(map.containsKey(src)) {
			ArrayList<Integer> list = map.get(src);
			list.add(dest);
			map.put(src, list);
		}else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(dest);
			map.put(src,list);
		}
		System.out.print("[" +src +"]"+"["+dest+"]=" + weight + ", ");
	}
	
	public void display() {
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			for(int i : entry.getValue()) {
				System.out.print("v"+(entry.getKey()+1) + "->" + "v"+(i+1) + ", ");
			}
			System.out.println();
		}
	}
	
	public void dijkstrasAlgorithm(int startingVertex,int destVertext) {
		if(startingVertex > map.size()) {
			System.out.println("wring vertex");
			return;
		}
		int src = zerothElement ? startingVertex : startingVertex-1;
		destVertext = zerothElement ? destVertext : destVertext-1;
		node[src] = new Node(src, 0, Status.perm, -1);
		Node minNode = node[src];
		while(startingVertex != destVertext) {
			//ArrayList<Integer> adjacentList = map.get(minNode.name);
			minNode = null;
			for(int i=0; i<node.length; i++) {
				int vertex = i;
				if(node[vertex].status == Status.perm || vertex == src || arr[src][vertex] == 0) {
					continue;
				}
				node[vertex].name = vertex;
				node[vertex].status = Status.temp;
				int distance = node[src].dist + arr[src][vertex];
				if(node[vertex].dist == Integer.MAX_VALUE || node[vertex].dist > distance) {
					node[vertex].dist = distance;
					node[vertex].pred = src;
				}
				

				if(minNode == null || (minNode.dist > node[vertex].dist && minNode.status != Status.perm)) {
					minNode = node[vertex];
				}
			}
			if(minNode != null) {
				minNode.status = Status.perm;	
				startingVertex = src = minNode.name;
			}else {
				break;
			}
			
			System.out.println(src + " node permanent" );
			System.out.println(node[src]);
			System.out.println("============");
		}
		System.out.println("Shortest path ");
		for(Node node : node) {
			if(node != null) {
				System.out.println(node);
			}
		}
	}
	
	public static void main(String[] args) {
		DijkstrasAlgorithm algo = new DijkstrasAlgorithm(9);
		
//		algo.addEdge(1, 2, 8);
//		algo.addEdge(1, 3, 2);
//		algo.addEdge(1, 4, 7);
//		
//		algo.addEdge(2, 6, 16);
//		
//		algo.addEdge(3, 1, 5);
//		algo.addEdge(3, 7, 3);
//		algo.addEdge(3, 4, 4);
//		
//		algo.addEdge(4, 5, 9);
//		
//		algo.addEdge(5, 1, 4);
//		algo.addEdge(5, 6, 5);
//		algo.addEdge(5, 8, 8);
//		
//		algo.addEdge(7, 3, 6);
//		algo.addEdge(7, 4, 3);
//		algo.addEdge(7, 5, 4);
//		
//		algo.addEdge(8, 6, 2);
//		algo.addEdge(8, 7, 5);
		
		algo.isOthElementThere(true);
		algo.addEdge(0, 1, 4);
		algo.addEdge(0, 7, 8);
		
		algo.addEdge(1, 0, 4);
		algo.addEdge(1, 2, 8);
		algo.addEdge(1, 7, 11);
		
		algo.addEdge(2, 1, 8);
		algo.addEdge(2, 3, 7);
		algo.addEdge(2, 5, 4);
		algo.addEdge(2, 8, 2);
		
		algo.addEdge(3, 2, 7);
		algo.addEdge(3, 4, 9);
		algo.addEdge(3, 5, 14);
		
		algo.addEdge(4, 3, 9);
		algo.addEdge(4, 5, 10);
		
		algo.addEdge(5, 2, 4);
		algo.addEdge(5, 3, 14);
		algo.addEdge(5, 4, 10);
		algo.addEdge(5, 6, 2);
		
		algo.addEdge(6, 5, 2);
		algo.addEdge(6, 7, 1);
		algo.addEdge(6, 8, 6);
		
		algo.addEdge(7, 0, 8);
		algo.addEdge(7, 1, 11);
		algo.addEdge(7, 6, 1);
		algo.addEdge(7, 8, 7);
		
		algo.addEdge(8, 2, 2);
		algo.addEdge(8, 6, 6);
		algo.addEdge(8, 7, 7);
		
		algo.display();
		algo.dijkstrasAlgorithm(0, 8);
	}
	
}
