package com.graph;

import java.util.ArrayList;
import java.util.Stack;


public class TopologicalSorting {
	
	public static void main(String[] args) {
		int V = 6;
		ArrayList<Edge> graph[] = new ArrayList[V];
		createGraph(graph);
		
		Stack<Integer> stack = topologicalSort(graph);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	private static Stack<Integer> topologicalSort(ArrayList<Edge>[] graph) {
		boolean[] isVisited = new boolean[graph.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i< graph.length; i++) {
			if (!isVisited[i]) {
				topologicalSort(graph, i, isVisited, stack);
			}
		}
		return stack;
	}
	
	private static void topologicalSort(ArrayList<Edge>[] graph, int current, 
			boolean[] isVisited, Stack<Integer> stack){
		isVisited[current] = true;
		
		for (int i=0; i< graph[current].size(); i++) {
			Edge edge = graph[current].get(i);
			if (!isVisited[edge.dest]) {
				topologicalSort(graph, edge.dest, isVisited, stack);
			}
		}
		
		stack.push(current);
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
		
		
		graph[2].add(new Edge(2, 3));
		
		graph[3].add(new Edge(3, 1));
		
		graph[4].add(new Edge(4, 0));
		graph[4].add(new Edge(4, 1));
		
		graph[5].add(new Edge(5, 0));
		graph[5].add(new Edge(5, 2));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	static String adjacentMatrix[][];
//	static int len;
//	static HashMap<Integer, String> map = new HashMap<Integer, String>();
//	public static void main(String[] args) {
//		Graph graph = new Graph(7, "matrix");
//		len = 7;
//		
//		map.put(0, "A");
//		map.put(1, "B");
//		map.put(2, "C");
//		map.put(3, "D");
//		map.put(4, "E");
//		map.put(5, "F");
//		map.put(6, "G");
//		
//		Graph.addEdge(graph, 0, 1);
//		Graph.addEdge(graph, 0, 5);
//		
//		Graph.addEdge(graph, 1, 4);
//		Graph.addEdge(graph, 1, 5);
//		
//		Graph.addEdge(graph, 2, 1);
//		Graph.addEdge(graph, 2, 3);
//		
//		Graph.addEdge(graph, 3, 1);
//		Graph.addEdge(graph, 3, 4);
//		
//		Graph.addEdge(graph, 6, 5);
//		Graph.addEdge(graph, 6, 4);
//		
//		for(int i=0; i<Graph.adjacencyMatrix.length; i++){
//			for(int j=0; j<Graph.adjacencyMatrix.length; j++){
//				System.out.print(Graph.adjacencyMatrix[i][j] + "	");
//			}
//			System.out.println();
//		}
//		
//		for(int i=0; i<Graph.adjacencyMatrix.length; i++){
//			System.out.print("Edges for Vertice " + map.get(i) + " : ");
//			for(int j=0; j<Graph.adjacencyMatrix.length; j++){
//				if(Graph.adjacencyMatrix[i][j]== 1){
//					System.out.print(map.get(i) + "->" + map.get(j) + " ");
//				}
//			}
//			System.out.println();
//			System.out.println();
//		}
//		topologicalSort();
//	}
//	
//	private static void topologicalSort(){
//		Queue<Integer> queue = new LinkedList<Integer>();
//		int[][] tmpGraph = new int[Graph.v][Graph.v];
//		tmpGraph = Graph.adjacencyMatrix;
//		for(int i=0; i<Graph.v; i++){
//			int indegree = indegree(i,tmpGraph);
//			if(indegree == 0){
//				queue.add(i);
//			}
//		}
//		
//		List<Integer> topologicalSortList =new ArrayList<Integer>();
//		
//		while(!queue.isEmpty()){
//			int vertice = queue.poll();
//			topologicalSortList.add(vertice);
//			tmpGraph = deleteVertice(tmpGraph, vertice);
//			for(int i=0; i<tmpGraph.length; i++){
//				if(queue.contains(i) || topologicalSortList.contains(i)){
//					continue;
//				}
//				int indegree = indegree(i, tmpGraph);
//				System.out.println("indegree of " + i + " " + indegree);
//				if( indegree == 0){
//					queue.add(i);
//				}
//			}
//			//topologicalSortList.add(vertice);
//			System.out.println(queue);
//		}
//		System.out.println(queue);
//		System.out.println("Topological sorting ...");
//		for(int i=0; i<topologicalSortList.size();i++){
//			System.out.print(map.get(topologicalSortList.get(i)));
//			if(i!=topologicalSortList.size()-1){
//				System.out.print("->");
//			}
//		}
//	}
//	
//	private static int indegree(int vertice,int[][] matrix){
//		int indegree = 0;
//		for(int i=0; i<len; i++){
//			if(matrix[i][vertice] == 1){
//				indegree++;
//			}
//		}
//		return indegree;
//	}
//	
//	private static int[][] deleteVertice(int[][] matrix,int vertice){
//		System.out.println("Deleted vertice " + vertice);
//		for(int i=0; i<len; i++){
//			matrix[i][vertice] = -1;
//		}
//		for(int i=0; i<len; i++){
//			matrix[vertice][i] = -1;
//		}
//		Graph.printGraphMatrix(matrix);
//		return matrix;
//	}
}
