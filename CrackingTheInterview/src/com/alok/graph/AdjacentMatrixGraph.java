/**
 * 
 */
package com.alok.graph;

/**
 * @author Alok Soni
 *
 */
public class AdjacentMatrixGraph {
	int v;
	int[][] arr;
	
	public AdjacentMatrixGraph(int v) {
		this.v = v;
		arr = new int[v][v];
	}

	
	public void addEdge(AdjacentMatrixGraph graph,int v, int e, int weight) {
		arr[v-1][e-1] = weight;
	}
	
	private void display(AdjacentMatrixGraph graph) {
		for(int i=0; i<graph.v; i++) {
			for(int j=0; j<graph.v;j++) {
				System.out.print(graph.arr[i][j] + "	");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		AdjacentMatrixGraph graph = new AdjacentMatrixGraph(4);
		graph.addEdge(graph, 1, 2, 2);
		graph.addEdge(graph, 1, 4, 8);
		
		graph.addEdge(graph, 2, 1, 3);
		graph.addEdge(graph, 2, 3, 4);
		graph.addEdge(graph, 2, 4, 7);
		
		graph.addEdge(graph, 3, 4, 5);
		
		graph.addEdge(graph, 4, 1, 9);
		graph.addEdge(graph, 4, 3, 6);
		
		graph.display(graph);
	}
}
