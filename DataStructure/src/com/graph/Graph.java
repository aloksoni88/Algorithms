package com.graph;

import java.util.LinkedList;

public class Graph {
	static int v;
	static String type;
	static LinkedList<Integer> adjacencyList[];
	static int adjacencyMatrix[][];
	
	public Graph(int v,String type){
		Graph.type = type;
		Graph.v = v;
		if(type.equalsIgnoreCase("list")){
			adjacencyList = new LinkedList[v];
			for(int i=0; i<v; i++){
				adjacencyList[i] = new LinkedList<Integer>();
			}
		}else{
			adjacencyMatrix = new int[v][v];
		}
		
	}
	
	public static Graph createGraph(Graph graph){
		addEdge(graph, 1, 2);
		addEdge(graph, 1, 4);
		addEdge(graph, 1, 5);
		addEdge(graph, 2, 3);
		addEdge(graph, 2, 5);
		addEdge(graph, 3, 6);
		addEdge(graph, 4, 7);
		addEdge(graph, 5, 6);
		addEdge(graph, 5, 8);
		addEdge(graph, 7, 5);
		addEdge(graph, 7, 8);
		addEdge(graph, 8, 9);
		
		printGraph(graph);
		return graph;
	}
	
	public static void addEdge(Graph graph, int src, int dest){
		if(graph.type.equalsIgnoreCase("matrix")){
			graph.adjacencyMatrix[src][dest] = 1;
		}else{
			graph.adjacencyList[src].add(dest);
		}
	}
	
	public static void addEdge(Graph graph, int src, int dest, int weight){
		if(graph.type.equalsIgnoreCase("matrix")){
			graph.adjacencyMatrix[src][dest] = weight;
		}else{
			graph.adjacencyList[src].add(dest);
		}
	}
	
	public static void printGraph(Graph graph){
		if(type.equalsIgnoreCase("matrix")){
			for(int i=0; i<v; i++){
				for(int k=0; k<v; k++){
					System.out.print(adjacencyMatrix[i][k] + "	");
				}
				System.out.println();
			}
		}else{
			for(int i=0; i<v; i++){
				System.out.println("For vertices : " + i + " edges are ");
				for(int x : adjacencyList[i]){
					System.out.print(x + " ");
				}
				System.out.println();
			}
		}
	}
	
	public static void printGraphMatrix(int[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				System.out.print(arr[i][j] + "	");
			}
			System.out.println();
		}
	}
}
