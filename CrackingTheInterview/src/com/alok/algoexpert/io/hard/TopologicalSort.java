/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;




/**
 * @author Alok Soni
 *
 */
public class TopologicalSort {
	public static void main(String[] args) {
		//Integer[] jobs = {0,1,2,3};
		//Integer[][] deps = {{0,1},{0,2},{1,2},{2,0},{2,3},{3,3}};
		Integer[] jobs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		Integer[][] deps = {
				{1, 2},
			    {1, 3},
			    {1, 4},
			    {1, 5},
			    {1, 6},
			    {1, 7},
			    {2, 8},
			    {3, 8},
			    {4, 8},
			    {5, 8},
			    {6, 8},
			    {7, 8},
			    {2, 3},
			    {2, 4},
			    {5, 4},
			    {7, 6},
			    {6, 2},
			    {6, 3},
			    {6, 5},
			    {5, 9},
			    {9, 8},
			    {8, 0},
			    {4, 0},
			    {5, 0},
			    {9, 0},
			    {2, 0},
			    {3, 9},
			    {3, 10},
			    {10, 11},
			    {11, 12},
			    {2, 12}
			    };
		List<Integer> jobList = new ArrayList<>(Arrays.asList(jobs));
		List<Integer[]> depList= new ArrayList<>();
		for(int i=0; i<deps.length; i++) {
			depList.add(deps[i]);
		}
		List<Integer> sortList = topologicalSort(jobList, depList);
		System.out.println(sortList);
	}

	public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
		if(jobs == null || jobs.isEmpty()) {
			return new ArrayList<Integer>();
		}else if(deps == null || deps.isEmpty()) {
			return jobs;
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0; i<deps.size(); i++) {
			Integer[] arr = deps.get(i);
			if(map.containsKey(arr[0])) {
				ArrayList<Integer> list = map.get(arr[0]);
				list.add(arr[1]);
				map.put(arr[0], list);
			}else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(arr[1]);
				map.put(arr[0], list);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		boolean isCyclic = isCyclic(map,jobs);
		System.out.println(isCyclic);
		if(isCyclic) {
			return list;
		}
		
		System.out.println(map);
		return topologicalSort(map,jobs);
	}
	
	private static List<Integer> topologicalSort(HashMap<Integer, ArrayList<Integer>> map ,
						List<Integer> jobs) {
		//display();
		Queue<Integer> queue = new LinkedList<Integer>();
		HashMap<Integer, Integer> indegree = new HashMap<>();
		for(int i=0; i<jobs.size(); i++) {
			indegree.put(jobs.get(i), 0);
		}

		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> list = entry.getValue();
			for(int i : list) {
				indegree.put(i, indegree.get(i)+1);
			}
		}
		System.out.println(indegree);
		
		for(int i=0; i<jobs.size(); i++) {
			if(indegree.get(jobs.get(i)) == 0) {
				queue.add(jobs.get(i));
			}
		}
		
		System.out.println(queue);
		ArrayList<Integer> sortList = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int vertext = queue.poll();
			sortList.add(vertext);
			
			map.remove(vertext);
			indegree = getIndegree(map,jobs,sortList);
			for(Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
				if(entry.getValue() == 0 && !queue.contains(entry.getKey()) 
						&& !sortList.contains(entry.getKey())) {
					queue.add(entry.getKey());
				}
			}
		}
		
		System.out.println("Topological sorting is : ");
		System.out.println(sortList);
		return sortList;
	}
	
	private static HashMap<Integer, Integer> getIndegree(HashMap<Integer, ArrayList<Integer>> map,
			List<Integer> jobs,List<Integer> sortedList) {
		HashMap<Integer, Integer> indegree = new HashMap<>();
		
		for(int i=0; i<jobs.size(); i++) {
			if(sortedList.contains(jobs.get(i))) {
				continue;
			}
			indegree.put(jobs.get(i), 0);
		}
		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> list = entry.getValue();
			for(int i : list) {
				if(!indegree.containsKey(entry.getKey())) {
					indegree.put(entry.getKey(), 0);
				}
				if(indegree.containsKey(i)) {
					indegree.put(i, indegree.get(i)+1);
				}else {
					indegree.put(i, 1);
				}
				
			}
		}
		//System.out.println(Arrays.toString(indegree));
		return indegree;
	}
	
	private static boolean isCyclic(HashMap<Integer, ArrayList<Integer>> map,List<Integer> jobs) {
		ArrayList<Boolean> visited=new ArrayList<Boolean>(Arrays.asList(new Boolean[jobs.size()+1]));
		Collections.fill(visited, Boolean.FALSE);
		for(int i=0; i<jobs.size(); i++) {
			if(isCycle(map, jobs.get(i), visited)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isCycle(HashMap<Integer, ArrayList<Integer>> map,
									int vertex, ArrayList<Boolean> visited) {
		if(visited.get(vertex)) {
		//if(visited[vertex]) {
			return true;
		}
		visited.set(vertex, true);
		//visited[vertex] = true;
		ArrayList<Integer> adjacentEdges =  map.get(vertex);
		if(adjacentEdges != null) {
			for(int i : adjacentEdges) {
				if(isCycle(map, i, visited)) {
					return true;
				}
			}
		}
		visited.set(vertex, false);
		//visited[vertex] = false;
		return false;
	}
}
