package com.graph;

import java.util.ArrayList;

public class FindCycleInUndirectedGraph {
	public static void main(String[] args) {
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);

		boolean result = findCycle(graph);
		System.out.println(result);
	}

	private static boolean findCycle(ArrayList<Edge>[] graph) {
		boolean[] isVisited = new boolean[graph.length];
		return isCycle(graph, 0, isVisited, -1);
	}

	private static boolean isCycle(ArrayList<Edge>[] graph, int current, boolean[] isVisited, int parent) {
		isVisited[current] = true;
		
		for (int i=0; i<graph[current].size(); i++) {
			Edge edge = graph[current].get(i);
			if (isVisited[edge.dest] && parent != edge.dest) {
				return true;
			} else if (!isVisited[edge.dest] && isCycle(graph, edge.dest, isVisited, current)) {
				return true;
			}
		}
		return false;
	}

	static class Edge {
		int src;
		int dest;

		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}

	private static void createGraph(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 4));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));
		//graph[1].add(new Edge(1, 4));

		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 2));
		
		graph[4].add(new Edge(4, 0));
		//graph[4].add(new Edge(4, 1));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 4));

	}
}
