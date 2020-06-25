package com.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {
	public static void main(String[] args) {
		Graph graph = new Graph(10, "list");
		Graph.createGraph(graph);
		
		dfsTraversal(graph,2);
	}
	
	private static void dfsTraversal(Graph graph,int statingVertext){
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> dfsList = new ArrayList();
		boolean[] visted = new boolean[graph.v];
		stack.add(statingVertext);
		//visted[statingVertext] = true;
		//dfsList.add(statingVertext);
		while(!stack.isEmpty()){
			int vertext = stack.pop();
			if(!visted[vertext]){
				visted[vertext] = true;
				dfsList.add(vertext);
			}else{
				continue;
			}
			if(graph.type.equalsIgnoreCase("matrix")){
				for(int i=graph.v-1; i>1; i--){
					if(graph.adjacencyMatrix[vertext][i] == 1 && !visted[i]){
						stack.add(i);
					}
				}
			}else{
				LinkedList<Integer> list = graph.adjacencyList[vertext];
				for(int i=list.size()-1; i>=0; i--){
					int ver = list.get(i);
					if(!visted[ver]){
						stack.add(ver);
					}
				}
			}
		}
		System.out.println("DFS traversal of graph is:");
		System.out.println(dfsList);
	}
}
