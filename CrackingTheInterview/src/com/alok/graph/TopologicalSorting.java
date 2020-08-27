/**{
 * 
 */
package com.alok.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alok Soni
 *
 */
public class TopologicalSorting {
	private int[][] arr;
	private int size;
	private Queue<Integer> queue = new LinkedList<Integer>();
	private ArrayList<ArrayList<Integer>> list;
	public TopologicalSorting(int size) {
		this.size = size;
		arr = new int[size][size];
		list = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<size; i++) {
			list.add(new ArrayList<Integer>());
		}
	}
	
	private void addEdge(int src,int dest) {
		arr[src][dest] = 1;
		list.get(src).add(dest);
	}
	
	private void display() {
//		for(int[] a : arr) {
//			System.out.println(Arrays.toString(a));
//		}
		
		for(ArrayList<Integer> l : list) {
			System.out.println(l);
		}
	}

	private void topologicalSort() {
		//display();
		int[] indegree = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			ArrayList<Integer> innerList = list.get(i);
			for(int x : innerList) {
				indegree[x]++;
			}
		}
		System.out.println(Arrays.toString(indegree));
		
		for(int i=0; i<indegree.length; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		System.out.println(queue);
		ArrayList<Integer> sortList = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int vertext = queue.poll();
			sortList.add(vertext);
			
			list.set(vertext,null);
			indegree = getIndegree(list);
			for(int i=0; i<indegree.length; i++) {
				if(indegree[i] == 0 && !queue.contains(i) && !sortList.contains(i)) {
					queue.add(i);
				}
			}
		}
		System.out.println("Topological sorting is : ");
		System.out.println(sortList);
	}
	
	private int[] getIndegree(ArrayList<ArrayList<Integer>> list) {
		int[] indegree = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			ArrayList<Integer> innerList = list.get(i);
			if(innerList != null) {
				for(int x : innerList) {
					indegree[x]++;
				}
			}
		}
		//System.out.println(Arrays.toString(indegree));
		return indegree;
	}
	
//	private void topologicalSort() {
//		for(int i=0; i<size ; i++) {
//			int indegree = 0;
//			int column = i;
//			for(int j=0; j<size; j++) {
//				if(arr[j][column] != 0) {
//					indegree++;
//				}
//			}
//			if(indegree == 0) {
//				queue.add(i);
//			}
//		}
////		while(!queue.isEmpty()) {
////			int vertext = queue.poll();
////			
////		}
//		System.out.println(queue);
//		removeVertex(queue.peek());
//		System.out.println();
//	}
	
	private int[][] removeVertex(int vertext){
		for(int i=0; i<size-1; i++) {
				arr[i][vertext] = arr[i][vertext+1];
		}
		
		for(int i=0; i<size-1 ; i++) {
			arr[vertext][i] = arr[vertext+1][i];
		}
		
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		TopologicalSorting ts = new TopologicalSorting(4);
		ts.addEdge(0, 1);
		ts.addEdge(0, 2);
		
		ts.addEdge(2, 1);
		
		ts.addEdge(3, 1);
		ts.addEdge(3, 2);
		
		
		
		ts.display();
		ts.topologicalSort();
	}
}	
