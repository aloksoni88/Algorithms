package com.graph;

import java.util.ArrayList;

public class PrimsAlgorithm {
	public static void main(String[] args) {
		Graph graph = new Graph(9, "matrix");
		
//		Graph.addEdge(graph, 0, 1, 5);
//		Graph.addEdge(graph, 0, 2, 14);
//		Graph.addEdge(graph, 0, 3, 9);
//		Graph.addEdge(graph, 0, 4, 7);
//		
//		Graph.addEdge(graph, 1, 0, 5);
//		Graph.addEdge(graph, 1, 3, 11);
//		Graph.addEdge(graph, 1, 5, 3);
//		
//		Graph.addEdge(graph, 2, 0, 14);
//		Graph.addEdge(graph, 2, 3, 2);
//		Graph.addEdge(graph, 2, 4, 8);
//		
//		Graph.addEdge(graph, 3, 0, 9);
//		Graph.addEdge(graph, 3, 1, 11);
//		Graph.addEdge(graph, 3, 2, 2);
//		Graph.addEdge(graph, 3, 4, 4);
//		Graph.addEdge(graph, 3, 5, 6);
//		
//		Graph.addEdge(graph, 4, 0, 7);
//		Graph.addEdge(graph, 4, 2, 8);
//		Graph.addEdge(graph, 4, 3, 4);
//		Graph.addEdge(graph, 4, 5, 19);
//		
//		Graph.addEdge(graph, 5, 1, 3);
//		Graph.addEdge(graph, 5, 3, 6);
//		Graph.addEdge(graph, 5, 4, 19);
		
		Graph.addEdge(graph, 0, 1, 4);
		Graph.addEdge(graph, 0, 7, 8);
		
		Graph.addEdge(graph,1, 0, 4);
		Graph.addEdge(graph,1, 2, 8);
		Graph.addEdge(graph,1, 7, 11);
		
		Graph.addEdge(graph,2, 1, 8);
		Graph.addEdge(graph,2, 3, 7);
		Graph.addEdge(graph,2, 5, 4);
		Graph.addEdge(graph,2, 8, 2);
		
		Graph.addEdge(graph,3, 2, 7);
		Graph.addEdge(graph,3, 4, 9);
		Graph.addEdge(graph,3, 5, 14);
		
		Graph.addEdge(graph,4, 3, 9);
		Graph.addEdge(graph,4, 5, 10);
		
		Graph.addEdge(graph,5, 2, 4);
		Graph.addEdge(graph,5, 3, 14);
		Graph.addEdge(graph,5, 4, 10);
		Graph.addEdge(graph,5, 6, 2);
		
		Graph.addEdge(graph,6, 5, 2);
		Graph.addEdge(graph,6, 7, 1);
		Graph.addEdge(graph,6, 8, 6);
		
		Graph.addEdge(graph,7, 0, 8);
		Graph.addEdge(graph,7, 1, 11);
		Graph.addEdge(graph,7, 6, 1);
		Graph.addEdge(graph,7, 8, 7);
		
		Graph.addEdge(graph,8, 2, 2);
		Graph.addEdge(graph,8, 6, 6);
		Graph.addEdge(graph,8, 7, 7);
		
		Graph.printGraph(graph);
		minmiumSpanningTree(graph,0);
	}
	
	private static void minmiumSpanningTree(Graph graph, int source){
		int destination = Graph.v-1;
		Node[] node = new Node[Graph.v];
		int currentNode = source;
		
		for(int i=0; i<Graph.v; i++){
			if(node[i] == null){
				node[i] = new Node();
			}
			if(i==source){
				node[i].distance = 0;
				node[i].predecessor = 0;
				node[i].status = true;
			}else{
				node[i] = new Node();
			}
		}
		
		System.out.println("Node	" + "dist	"+ "pred	" + "status");
		for(int i=0; i<Graph.v; i++){
			System.out.println(i + "	" + node[i].distance + "	" + node[i].predecessor + "	" + node[i].status);
		}
		System.out.println();
		
		boolean isAllTrue  = false;
		ArrayList<Integer> minimumSpanningTree = new ArrayList<Integer>();
		minimumSpanningTree.add(0);
		while(!isAllTrue){
			for(int i=0; i<Graph.v; i++){
				int distance = Graph.adjacencyMatrix[currentNode][i];
				if(distance != 0 && !node[i].status &&  node[i].distance > distance){
					node[i].distance= distance;
					node[i].predecessor = currentNode;
				}
			}
			Node minDistanceNode = new Node();
			int minDistanceIndex = -1;
			isAllTrue = true;
			for(int i=0; i<node.length; i++){
				if(!node[i].status){
					isAllTrue = false;
					if(minDistanceNode.distance > node[i].distance){
						minDistanceNode = node[i];
						minDistanceIndex = i;	
					}
				}
			}
			if(minDistanceIndex != -1){
				node[minDistanceIndex].distance = minDistanceNode.distance;
				node[minDistanceIndex].predecessor = minDistanceNode.predecessor;
				node[minDistanceIndex].status = true;
				currentNode = minDistanceIndex;
				minimumSpanningTree.add(minDistanceIndex);
			}
			System.out.println();
			System.out.println("Node	" + "dist	"+ "pred	" + "status");
			for(int i=0; i<Graph.v; i++){
				System.out.println(i + "	" + node[i].distance + "	" + node[i].predecessor + "	" + node[i].status);
			}
		}
		
		System.out.println(minimumSpanningTree);
		
		int weight = 0;
		for(int i=0; i<minimumSpanningTree.size()-1; i++){
			int src = minimumSpanningTree.get(i);
			int dest = minimumSpanningTree.get(i+1);
			weight = weight + Graph.adjacencyMatrix[src][dest];
		}
		System.out.println("Minimum weight of spanning tree " + weight);
	}
}
