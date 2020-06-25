package com.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class GraphAdjacencyMatrix {
	public static void main(String[] args) {
		Graph graph = new Graph(5, "list");
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
        
        Graph.printGraph(graph);
	}	
	
	private static void addEdge(Graph graph,int src, int dest){
		if(Graph.type.equalsIgnoreCase("matrix")){
			Graph.adjacencyMatrix[src][dest] = 1;
			Graph.adjacencyMatrix[dest][src] = 1;
		}else{
			Graph.adjacencyList[src].add(dest);
			Graph.adjacencyList[dest].add(src);
		}
	}
	
	/*private static void printGraph(Graph graph){
		if(graph.type.equalsIgnoreCase("matrix")){
			for(int i=0; i<graph.v; i++){
				for(int k=0; k<graph.v; k++){
					System.out.print(graph.adjacencyMatrix[i][k] + " ");
				}
				System.out.println();
			}
		}else{
			for(int i=0; i<graph.v; i++){
				LinkedList<Integer> list = graph.adjacencyList[i];
				System.out.println("For vertex " + i + " edges are ");
				for(Integer x : list){
					System.out.print(x + " ");
				}
				System.out.println();
			}
		}
	}*/
}
