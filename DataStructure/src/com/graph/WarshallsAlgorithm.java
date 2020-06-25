package com.graph;

public class WarshallsAlgorithm {
	public static void main(String[] args) {
		Graph graph = new Graph(4, "matrix");
		
		Graph.addEdge(graph, 0, 1);
		Graph.addEdge(graph, 0, 3);
		Graph.addEdge(graph, 1, 0);
		Graph.addEdge(graph, 1, 2);
		Graph.addEdge(graph, 1, 3);
		Graph.addEdge(graph, 2, 3);
		Graph.addEdge(graph, 3, 0);
		Graph.addEdge(graph, 3, 2);
		
		
		Graph.printGraph(graph);
		pathMatrix(graph);
	}
	
	private static void pathMatrix(Graph graph){
		int count = graph.v;
		int[][] pathMatrix = graph.adjacencyMatrix;
		int[][] adjacecyMatrix = graph.adjacencyMatrix;
		for(int i=0; i<count; i++){
			for(int x=0; x< count; x++){
				for(int y=0; y<count; y++){
					if(pathMatrix[x][y] == 0 && x != i && y != i 
							&& adjacecyMatrix[x][i] == 1 && adjacecyMatrix[i][y] == 1){
						pathMatrix[x][y] = 1;
					}
				}
			}
			adjacecyMatrix = pathMatrix;
			System.out.println("Adjacecy Matrix for " + i);
			Graph.printGraphMatrix(adjacecyMatrix);
		}
		
		System.out.println("Path matrix..");
		Graph.printGraphMatrix(pathMatrix);
	}
	
	
}
