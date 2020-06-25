/**
 * 
 */
package com.alok.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alok Soni
 * Minimum spanning tree algorithm
 *
 */
public class PrimsAlgorithm {
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
	private Node[] node;
	
	public PrimsAlgorithm(int size) {
		arr = new int[size][size];
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
		System.out.print("[" +src +"]"+"["+dest+"]=" + weight + ", ");
	}
	
	
	public void primsAlgorithm(int startingVertex) {
		startingVertex = zerothElement ? startingVertex : startingVertex-1;
		node[startingVertex].name = startingVertex;
		node[startingVertex].dist = 0;
		node[startingVertex].pred = -1;
		node[startingVertex].status = Status.perm;
		int src = startingVertex;
		boolean isAllPermanent = false;
		
		while(!isAllPermanent) {
			isAllPermanent = true;
			Node minNode=null;
			for(int i=0; i<node.length; i++) {
				if(node[i].status == Status.perm) {
					continue;
				}
				isAllPermanent = false;
				
				if(i == src || arr[src][i] == 0) {
					continue;
				}
				
				if(node[i].dist == Integer.MAX_VALUE || node[i].dist > arr[src][i]) {
					node[i].dist = arr[src][i];
					node[i].pred = src;
				}
				if(minNode == null || minNode.dist > node[i].dist && node[i].status != Status.perm) {
					minNode = node[i];
				}
			}	
			if(minNode != null) {
				minNode.status = Status.perm;
				src = minNode.name;
			}else {
				System.out.println();
				System.out.println("====");
				break;
			}
			
			System.out.println("Node set to permanent " + src);
			System.out.println(node[src]);
		}
	}
	
	public static void main(String[] args) {
		PrimsAlgorithm algo = new PrimsAlgorithm(9);
		
//		algo.addEdge(1, 2, 5);
//		algo.addEdge(1, 3, 14);
//		algo.addEdge(1, 4, 9);
//		algo.addEdge(1, 5, 7);
//		
//		algo.addEdge(2, 1, 5);
//		algo.addEdge(2, 4, 11);
//		algo.addEdge(2, 6, 3);
//		
//		algo.addEdge(3, 1, 14);
//		algo.addEdge(3, 4, 2);
//		algo.addEdge(3, 5, 8);
//		
//		algo.addEdge(4, 1, 9);
//		algo.addEdge(4, 2, 11);
//		algo.addEdge(4, 3, 2);
//		algo.addEdge(4, 5, 4);
//		algo.addEdge(4, 6, 4);
//		
//		algo.addEdge(5, 1, 7);
//		algo.addEdge(5, 3, 8);
//		algo.addEdge(5, 4, 4);
//		algo.addEdge(5, 6, 19);
//		
//		algo.addEdge(6, 2, 3);
//		algo.addEdge(6, 4, 6);
//		algo.addEdge(6, 5, 19);
		
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
		
		algo.primsAlgorithm(0);
		System.out.println(Arrays.toString(algo.node));
	}
}
