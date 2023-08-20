package com.graph;

import java.util.ArrayList;

import com.graph.AllPathFromSrcToDest.Edge;

public class FindCycleInDirectedGraph {
	public static void main(String[] args) {
		int V = 4;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		
		boolean result = findCycle(graph);
		System.out.println(result);
	}
	
	private static boolean findCycle(ArrayList<Edge>[] graph) {
		boolean[] isVisited = new boolean[graph.length];
		boolean[] stackVisited = new boolean[graph.length];
		return isCycle(graph, 0, isVisited, stackVisited);
	}
	
	private static boolean isCycle(ArrayList<Edge>[] graph, int current, boolean[] isVisited, boolean stc[]) {
		isVisited[current]= true;
		stc[current] = true;
		
		for (int i=0; i<graph[current].size(); i++) {
			Edge edge = graph[current].get(i);
			if (stc[edge.dest]) {
				return true;
			}
			else if (!isVisited[edge.dest] && isCycle(graph, edge.dest, isVisited, stc)) {
				return true;
			}
		}
		stc[current] = true; 
		return false;
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
		
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 0));
		
		graph[2].add(new Edge(2, 3));
		
		graph[3].add(new Edge(3, 0));
		
	}
}
