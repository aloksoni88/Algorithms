/**
 * 
 */
package com.alok.graph;

/**
 * @author Alok Soni
 *
 */
public class WarshallsAlgorithm {
	private int v;
	private int arr[][];
	
	public WarshallsAlgorithm(int v) {
		this.v = v;
		arr = new int[v][v];
	}
	
	public void addEdge(int v, int e, int weight) {
		arr[v][e]  = weight;
	}
	
	private void createInitialMatrix() {
		for(int i=0; i<v; i++) {
			for(int j=0; j<v; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1000;
				}
			}
		}
	}
	
	public void display() {
		for(int i=0; i<v; i++) {
			for(int j=0; j<v;j++) {
				System.out.print(arr[i][j] + "		");
			}
			System.out.println();
		}
	}
	
	public void applyAlog() {	
		for(int i=0; i<v; i++) {
			for(int x=0; x<v; x++) {
				for(int y=0; y<v; y++) {
					arr[x][y] = minimum(arr[x][y], (arr[x][i] + arr[i][y]));
				}
			}
			System.out.println();
			display();
		}
	}
	
	private int minimum(int a, int b) {
		if(a < b) {
			return a;
		}
		return b;
	}
	
	public static void main(String[] args) {
		WarshallsAlgorithm warAlgorithm = new WarshallsAlgorithm(4);
		warAlgorithm.addEdge(0, 1, 2);
		warAlgorithm.addEdge(0, 3, 9);
		
		warAlgorithm.addEdge(1, 0, 3);
		warAlgorithm.addEdge(1, 2, 4);
		warAlgorithm.addEdge(1, 3, 7);
		
		warAlgorithm.addEdge(2, 1, 6);
		warAlgorithm.addEdge(2, 3, 2);
		
		warAlgorithm.addEdge(3, 0, 14);
		warAlgorithm.addEdge(3, 2, 4);
		
		warAlgorithm.createInitialMatrix();
		
		warAlgorithm.display();
		
		warAlgorithm.applyAlog();
		System.out.println("===============================");
		warAlgorithm.display();
	}
}