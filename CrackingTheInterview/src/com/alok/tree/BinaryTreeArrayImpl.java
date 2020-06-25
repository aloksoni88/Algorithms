/**
 * 
 */
package com.alok.tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Alok Soni
 *
 */
public class BinaryTreeArrayImpl {
	private static ArrayList<String> arrayList = new ArrayList<String>();
	private static HashMap<String, Integer> nodeIndexMap = new HashMap<String, Integer>();
	
	private static void add(String item, String root, boolean isLeft) {
		int index;
		if(arrayList.isEmpty() && root == null) {
			index = 0;
			nodeIndexMap.put("A", index);
			arrayList.add(item);
			return;
		}else {
			index = nodeIndexMap.get(root);
		}
		if(isLeft) {
			index = 2 * index + 1;
		}else {
			index = 2 * index + 2;
		}
		if(!nodeIndexMap.containsKey(item)) {
			nodeIndexMap.put(item, index);	
		}
		if(index >= arrayList.size()) {
			for(int i=arrayList.size(); i<index; i++) {
				arrayList.add(null);
			}
		}
		arrayList.add(index, item);
	}
	
	
	
	public static void main(String[] args) {
		add("A",null,false);
		add("B","A",true);
		add("C","A",false);
		add("D","B",true);
		add("E","B",false);
		add("F","C",false);
		
		
		System.out.println(arrayList);
	}
}
