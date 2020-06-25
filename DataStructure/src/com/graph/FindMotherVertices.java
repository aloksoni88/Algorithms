package com.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindMotherVertices {
	public static void main(String[] args) {
		Graph graph = new Graph(7, "list");
		Graph.addEdge(graph, 0, 1);
		Graph.addEdge(graph, 0, 2);
		Graph.addEdge(graph, 1, 3);
		Graph.addEdge(graph, 4, 1);
		Graph.addEdge(graph, 5, 2);
		Graph.addEdge(graph, 5, 6);
		Graph.addEdge(graph, 6, 0);
		Graph.addEdge(graph, 6, 4);
		
		graph.printGraph(graph);
		
		findMotherVertices(graph);
	}
	
	private static void findMotherVertices(Graph graph){
		List<Integer> montherVertices = new ArrayList<Integer>();
		for(int i=0; i<graph.v; i++){
			int v = getMotherVertices(graph, i);
			if(v != -1){
				montherVertices.add(v);
			}
		}
		System.out.println("Monther vertices...");
		System.out.println(montherVertices);
	}
	
	private static int getMotherVertices(Graph graph, int vertices){
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.v];
		Set<Integer> bfs = new HashSet<Integer>();
		queue.add(vertices);
		visited[vertices] = true;
		bfs.add(vertices);
		while(!queue.isEmpty()){
			int v = queue.poll();
			if(graph.type.equalsIgnoreCase("matrix")){
				for(int i=0; i<graph.v; i++){
					if(graph.adjacencyMatrix[v][i] == 1 && !visited[i]){
						visited[i] = true;
						queue.add(i);
						bfs.add(i);
					}
				}
			}else{
				LinkedList<Integer> list = graph.adjacencyList[v];
				for(int i : list){
					if(!visited[i]){
						visited[i] = true;
						queue.add(i);
						bfs.add(i);
					}
				}
			}
		}
		System.out.println(bfs);
		if(bfs.size() == graph.v){
			return vertices;
		}
		
		return -1;
	}
}
