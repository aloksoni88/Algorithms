package com.graph;

public class WarshallsShortestPath {
	public static void main(String[] args) {
		Graph graph = new Graph(4, "matrix");
		
		Graph.addEdge(graph, 0, 1,2);
		Graph.addEdge(graph, 0, 3,9);
		Graph.addEdge(graph, 1, 0,3);
		Graph.addEdge(graph, 1, 2,4);
		Graph.addEdge(graph, 1, 3,7);
		Graph.addEdge(graph, 2, 3,2);
		Graph.addEdge(graph, 2, 1,6);
		Graph.addEdge(graph, 3, 0,14);
		Graph.addEdge(graph, 3, 2,4);
		
		
		Graph.printGraph(graph);
		shortestPathMatrix(graph);
	}
	
	private static void shortestPathMatrix(Graph graph){
		int count = Graph.v;
		for(int i=0; i<count; i++){
			for(int j=0; j<count; j++){
				if(i==j){
					Graph.adjacencyMatrix[i][j] = 0;
				}else if(Graph.adjacencyMatrix[i][j] == 0){
					Graph.adjacencyMatrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		System.out.println();
		Graph.printGraphMatrix(Graph.adjacencyMatrix);
		int[][] pathMatrix = Graph.adjacencyMatrix;
		int[][] adjacecyMatrix = Graph.adjacencyMatrix;
		System.out.println();
		for(int i=0; i<count; i++){
			for(int x=0; x< count; x++){
				for(int y=0; y<count; y++){
					if(x != i && y != i 
							&& adjacecyMatrix[x][i] != Integer.MAX_VALUE && adjacecyMatrix[i][y] != Integer.MAX_VALUE
							&& ((adjacecyMatrix[x][i] + adjacecyMatrix[i][y]) < pathMatrix[x][y] || pathMatrix[x][y] == 0)){
						pathMatrix[x][y] = adjacecyMatrix[x][i] + adjacecyMatrix[i][y];
					}
				}
			}
			adjacecyMatrix = pathMatrix;
			System.out.println("Adjacecy Matrix for " + i);
			Graph.printGraphMatrix(adjacecyMatrix);
		}
		
		System.out.println();
		System.out.println("Path matrix..");
		Graph.printGraphMatrix(pathMatrix);
	}
}
