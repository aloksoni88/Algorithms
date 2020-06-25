package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
	private static String type = "list";
	public static void main(String[] args) {
		Graph graph = new Graph(10, type);
		graph = graph.createGraph(graph);
		
		bfsTraversal(graph, 1);
	}
	
	
	
	private static void bfsTraversal(Graph graph,int startingVertices){
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[graph.v];
		LinkedList<Integer> bfsList = new LinkedList<Integer>();
		queue.add(startingVertices);
		visited[startingVertices] = true;
		bfsList.add(startingVertices);
		while(!queue.isEmpty()){
			int vertext = queue.poll();
			//bfsList.add(vertext);
			
			if(graph.type.equalsIgnoreCase("matrix")){
				for(int i=0; i<graph.v; i++){
					if(graph.adjacencyMatrix[vertext][i] == 1 && !visited[i]){
						queue.add(i);
						visited[i] = true;
						bfsList.add(i);
					}
				}
			}else{
				LinkedList<Integer> list = graph.adjacencyList[vertext];
				for(int i : list){
					if(!visited[i]){
						visited[i] =  true;
						queue.add(i);
						bfsList.add(i);
					}
				}
			}
		}
		System.out.println("BES travsersal "  + bfsList);
	}
}
