package com.graph;

import java.util.ArrayList;

public class AllPathFromSrcToDest {
	public static void main(String[] args) {
		int V = 7;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		
		allPathFromSrcToDest(graph, 5);
	}
	
	private static void allPathFromSrcToDest(ArrayList<Edge>[] graph, int dest) {
		boolean[] isVisited = new boolean[graph.length]; 
		findPath(graph, 0, dest, isVisited, "0");
	}
	
	private static void findPath(ArrayList<Edge>[] graph, int current, int dest, boolean[] isVisited, String path) {
		if (current == dest) {
			System.out.println(path);
			return;
		}
		
		for (int i=0; i< graph[current].size(); i++) {
			Edge edge = graph[current].get(i);
			if (!isVisited[edge.dest]) {
				isVisited[current] = true;
				findPath(graph, edge.dest, dest, isVisited, path + edge.dest);
				isVisited[current] = false;
			}
		}
	}
	
	static class Edge{
		int src;
		int dest;
		
		public Edge (int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}
	
	private static void createGraph(ArrayList<Edge>[] graph) {
		for (int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));
		
		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));
		
		graph[6].add(new Edge(6, 5));
	}
}
