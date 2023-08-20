package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {
	public static void main(String[] args) {
		int v = 7;
		ArrayList<Edge> graph[] = new ArrayList[v];
		createGraph(graph);
		
		bfsTraversal(graph);
	}
	
	static class Edge{
		int src, dest;
		
		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}
	
	public static void bfsTraversal(ArrayList<Edge>[] graph) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		boolean v[]  = new boolean[graph.length];
		queue.add(0);
		
		while(!queue.isEmpty()) {
			int current = queue.remove();
			if (!v[current]) {
				System.out.print(current + " ");
				v[current] = true;
				
				for (int i=0; i<graph[current].size(); i++) {
					Edge edge = graph[current].get(i);
					queue.add(edge.dest);
				}
			}
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i=0; i< graph.length; i++) {
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
