package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class KruskalsAlgorithm {
	public static void main(String[] args) {
		Graph graph = new Graph(9, "matrix");
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		
		Graph.addEdge(graph, 0, 1, 9);
		Graph.addEdge(graph, 0, 3, 4);
		Graph.addEdge(graph, 0, 4, 2);	
		
		Graph.addEdge(graph, 1, 0, 9);
		Graph.addEdge(graph, 1, 4, 8);
		Graph.addEdge(graph, 1, 2, 10);
		
		Graph.addEdge(graph, 2, 1, 10);
		Graph.addEdge(graph, 2, 4, 7);
		Graph.addEdge(graph, 2, 5, 5);
		
		Graph.addEdge(graph, 3, 0, 4);
		Graph.addEdge(graph, 3, 4, 3);
		Graph.addEdge(graph, 3, 6, 18);
		
		Graph.addEdge(graph, 4, 0, 2);
		Graph.addEdge(graph, 4, 1, 8);
		Graph.addEdge(graph, 4, 2, 7);
		Graph.addEdge(graph, 4, 3, 3);
		Graph.addEdge(graph, 4, 5, 6);
		Graph.addEdge(graph, 4, 6, 11);
		Graph.addEdge(graph, 4, 7, 12);
		Graph.addEdge(graph, 4, 8, 15);
		
		Graph.addEdge(graph, 5, 2, 5);
		Graph.addEdge(graph, 5, 4, 6);
		Graph.addEdge(graph, 5, 8, 16);
		
		Graph.addEdge(graph, 6, 3, 18);
		Graph.addEdge(graph, 6, 4, 11);
		Graph.addEdge(graph, 6, 7, 14);
		
		Graph.addEdge(graph, 7, 4, 12);
		Graph.addEdge(graph, 7, 6, 14);
		Graph.addEdge(graph, 7, 8, 20);
		
		Graph.addEdge(graph, 8, 4, 15);
		Graph.addEdge(graph, 8, 5, 16);
		Graph.addEdge(graph, 8, 7, 20);
		
		Graph.printGraph(graph);
		
		for(int i=0; i<Graph.v; i++){
			for(int j=0; j<Graph.v; j++){
				if(Graph.adjacencyMatrix[i][j] != 0){
					edgeList.add(new Edge(i, j, Graph.adjacencyMatrix[i][j]));
				}
			}
		}
		Collections.sort(edgeList,new Comparator<Edge>() {
			public int compare(Edge edge1, Edge edge2) {
				return edge1.weight - edge2.weight;
			}
		});
		System.out.println(edgeList);
		ArrayList<Edge>sortedEdgeList = new ArrayList<Edge>(); 
		for(int i=0; i<edgeList.size(); i++){
			if(i%2==0){
				sortedEdgeList.add(edgeList.get(i));
			}
		}
		System.out.println(sortedEdgeList);
		minimumSpanningTree(sortedEdgeList);
	}
	
	private static void minimumSpanningTree(ArrayList<Edge> edgeList){
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		ArrayList<Edge> minSpanningTreeList = new ArrayList<Edge>();
		
		//initial fill all node's father 0
		for(int i=0; i<Graph.v; i++){
			map.put(i, -1);
		}
		
		for(int i=0; i<edgeList.size(); i++){
			Edge edge = edgeList.get(i);
			int n1 = edge.src;
			int n2 = edge.dest;
			
			int root_n1 = map.get(n1);
			if(root_n1 == -1){
				root_n1 = n1;
			}else{
				while(map.get(root_n1) != -1){
					root_n1 = map.get(root_n1);
				}
			}
			int root_n2 = map.get(n2);
			if(root_n2 == -1){
				root_n2 = n2;
			}else{
				while(map.get(root_n2) != -1){
					root_n2 = map.get(root_n2);
				}
			}
			if(root_n1 == root_n2){
				System.out.println("Selected edge : " + edge.src + "-" + edge.dest);
				System.out.println("Node	" + map.keySet());
				System.out.println("Father	" + map.values());
				System.out.println();
				continue;
			}
			map.put(root_n2, root_n1);
			minSpanningTreeList.add(edge);
			System.out.println("Selected edge : " + edge.src + "-" + edge.dest);
			System.out.println("Node	" + map.keySet());
			System.out.println("Father	" + map.values());
			System.out.println();
		}
		
		System.out.println("Minimum spanning tree");
		System.out.println(minSpanningTreeList);
		System.out.print("Minimum weight of spanning tree is:");
		int weight = 0;
		for(int i=0; i<minSpanningTreeList.size(); i++){
			weight = weight + minSpanningTreeList.get(i).weight;
		}
		System.out.print(weight);
	}
}

class Edge{
	int src;
	int dest;
	int weight;
	public Edge(int src,int dest,int weight){
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return src + "->" +dest + "=" + weight;
	}
}
