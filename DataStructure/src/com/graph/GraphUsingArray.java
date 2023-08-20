package com.graph;

import java.util.ArrayList;

public class GraphUsingArray {
	public static void main(String[] args) {
		int v = 4;
		ArrayList<Edge> graph[] = new ArrayList[v];
		createGraph(graph);
		
		for (ArrayList<Edge> edges: graph) {
			for (Edge edge: edges) {
				System.out.println(edge.src + " -> " + edge.dest + " with weight : " + edge.weight);
			}
			System.out.println();
		}
	}
	
	static class Edge{
		int src;
		int dest;
		int weight;
		
		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i=0; i< graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0, 2, 2));
		
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 4));
		
		graph[2].add(new Edge(2, 0, -1));
		graph[2].add(new Edge(2, 1, 2));
		graph[2].add(new Edge(2, 3, 4));
		
		graph[3].add(new Edge(3, 1, 4));
		graph[3].add(new Edge(3, 2, 3));
	}
}
