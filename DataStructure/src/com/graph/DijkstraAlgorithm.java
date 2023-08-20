package com.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	
	public static void main(String[] args) {
		int v = 6;
		ArrayList<Edge> graph[] = new ArrayList[v];
		createGraph(graph);
		
		dikkstras(graph, 0, v);
	}
	
	private static void dikkstras(ArrayList<Edge>[] graph, int src, int V) {
		PriorityQueue<Pair> pq = new PriorityQueue<DijkstraAlgorithm.Pair>();
		
		int dist[] = new int[V];
		for (int i=0; i< V; i++) {
			if (i!= src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		boolean[] isVisited = new boolean[V];
		
		pq.add(new Pair(0, 0));
		
		while(!pq.isEmpty()) {
			Pair pair = pq.remove();
			
			if (!isVisited[pair.node]) {
				isVisited[pair.node] = true;
				
				for (int i=0; i< graph[pair.node].size(); i++) {
					Edge edge = graph[pair.node].get(i);
					
					int u = edge.src;
					int v = edge.dest;
					
					if (dist[u] + edge.weight < dist[v]) {
						dist[v] = dist[u] + edge.weight;
					}
					
				}
			}
		}
		
		for (int i=0; i<V; i++) {
			System.out.print(dist[i] + " ");
		}
		
		System.out.println();
	}
	
	static class Pair implements Comparable<Pair>{
		int node;
		int dist;
		
		public Pair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}

		public int compareTo(Pair pair2) {
			return this.dist - pair2.dist;
		}
	}
	
	static class Edge{
		int src, dest, weight;
		
		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i=0; i< graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));
		
		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 7));
		
		graph[2].add(new Edge(2, 4, 3));
		
		graph[3].add(new Edge(3, 5, 1));
		
		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		Graph graph = new Graph(8, "matrix");
//		Graph.addEdge(graph, 0, 1, 8);
//		Graph.addEdge(graph, 0, 2, 2);
//		Graph.addEdge(graph, 0, 3, 7);
//		
//		Graph.addEdge(graph, 1, 5, 16);
//		
//		Graph.addEdge(graph, 2, 0, 5);
//		Graph.addEdge(graph, 2, 3, 4);
//		Graph.addEdge(graph, 2, 6, 3);
//
//		Graph.addEdge(graph, 3, 4, 9);
//		
//		Graph.addEdge(graph, 4, 0, 4);
//		Graph.addEdge(graph, 4, 5, 5);
//		Graph.addEdge(graph, 4, 7, 8);
//		
//		Graph.addEdge(graph, 6, 2, 6);
//		Graph.addEdge(graph, 6, 3, 3);
//		Graph.addEdge(graph, 6, 4, 4);
//		//Graph.addEdge(graph, 6, 7, 5);
//		
//		Graph.addEdge(graph, 7, 5, 2);
//		Graph.addEdge(graph, 7, 6, 5);
//		
//		Graph.printGraph(graph);
//		int shortestPath = findShortestPath(0, 6, graph);
//		System.out.println("Shortest distance : " +  shortestPath);
//	}
//	
//	private static int findShortestPath(int source, int destination,Graph graph){
//		Node[] node = new Node[graph.v];
//		
//		for(int i=0; i<graph.v; i++){
//			if(node[i]== null){
//				node[i] = new Node();
//			}
//			if(source == i){
//				node[i].predecessor = 0;
//				node[i].distance = 0;
//				node[i].status = true;
//			}else{
//				node[i] = new Node();				
//			}
//		}
//		int currentNode = source;		
//		
//		while(currentNode != destination){
//			
//			boolean sink = true;
//			for(int i=0; i<graph.v; i++){
//				int distance = Graph.adjacencyMatrix[currentNode][i];
//				if(distance != 0 && !node[i].status && node[i].distance > (node[currentNode].distance + distance)){
//					node[i].distance = node[currentNode].distance + distance;
//					node[i].predecessor = currentNode;
//					System.out.println(node[i]);
//					sink = false;
//				}
//			}
//			if(sink){
//				System.out.println("No path from "+ source + " to " + destination);
//				return -1;
//			}
//			Node minDistance = new Node();
//			int minDistanceIndex = -1;
//			for(int i=0; i<graph.v; i++){
//				if(!node[i].status && minDistance.distance > node[i].distance){
//					minDistance = node[i];
//					minDistanceIndex = i;
//					System.out.println("min "+node[i]);
//				}
//			}
//			
//			if(minDistanceIndex != -1 && !node[minDistanceIndex].status){
//				node[minDistanceIndex].status = true;
//				node[minDistanceIndex].predecessor = minDistance.predecessor;
//				node[minDistanceIndex].distance = minDistance.distance;
//				currentNode = minDistanceIndex;
//				System.out.println("current node : " + currentNode + ", " + node[minDistanceIndex]);
//			}
//			
//		}
//		System.out.println("Node	" + "dist	"+ "pred	" + "status");
//		for(int i=0; i<graph.v; i++){
//			System.out.println(i + "	" + node[i].distance + "	" + node[i].predecessor + "	" + node[i].status);
//		}
//		int pred = destination;
//		Stack<Integer> path = new Stack<Integer>();
//		while(pred != source){
//			path.add(pred);
//			pred = node[pred].predecessor;
//		}
//		path.add(source);
//		System.out.print("Shortest Path : ");
//		while(!path.isEmpty()){
//			System.out.print(path.pop() + "-->");
//		}
//		System.out.println();
//		return node[destination].distance;
//		
//	}
//}
//
//class Node{
//	int predecessor;
//	int distance;
//	boolean status;
//	
//	public Node(){
//		predecessor = -1;
//		distance = Integer.MAX_VALUE;
//		status = false;
//	}
//	
//	
//	public int getPredecessor() {
//		return predecessor;
//	}
//	public void setPredecessor(int predecessor) {
//		this.predecessor = predecessor;
//	}
//	public int getDistance() {
//		return distance;
//	}
//	public void setDistance(int distance) {
//		this.distance = distance;
//	}
//	public boolean isStatus() {
//		return status;
//	}
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
//	
//	@Override
//	public String toString() {
//		return distance + " " + predecessor + " " + status;
//	}
}
