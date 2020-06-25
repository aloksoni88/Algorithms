/**
 * 
 */
package com.alok.tree;

import java.util.HashMap;

/**
 * @author Alok Soni
 *
 */
class Program {
	//private int[] arr = [3,5,-4,8,11,1,-1,6];
	//sum = 10
  public static int[] twoNumberSum(int[] array, int targetSum) {
		if(array == null || array.length == 0){
			   return new int[0];
		}
       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
 
		for(int i=0; i<array.length; i++){
				
				if(map.containsKey(array[i]) && map.get(array[i]) == map.get(map.get(array[i]))){
					return new int[]{map.get(map.get(array[i])),array[i]};
				}
				map.put((targetSum- array[i]), array[i]);
		}
    return new int[0];
  }
}
