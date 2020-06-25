package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author mehar
 * 
 * Problem:

The input is a list of names in random order. We need a function that chains elements of the list in such a way
 that the last character of an name is the same as the first one of the next name. For instance:

Input: ["Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban"]

Output: ["Peter", "Raymond", "Daniel", "Louie", "Esteban", "Nora"]

Hint: There should be only one solution, so the first element is unique.
 *
 */
public class Chaining {
	public static void main(String[] args) {
		String[] inputArr = {"Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban"};
		chainElement(inputArr);
	}
	
	private static void chainElement(String[] arr){
		List<String> output = new ArrayList();
		List<String> uniqueList = new ArrayList();
		List<String> inputList = new ArrayList<String>();
		if(arr != null && arr.length > 0){
			for(int i=0; i<arr.length; i++){
				inputList.add(arr[i]);
			}
		}
		//find uniqu word
		if(arr != null && arr.length > 0){
			for(int i=0; i<arr.length; i++){
				boolean isUniqeword = true;
				for(int j=0; j<arr.length; j++){
					if(i==j){
						continue;
					}
					if(arr[i].toLowerCase().toCharArray()[0] == arr[j].toLowerCase().toCharArray()[arr[j].length()-1]){
						isUniqeword = false;
					}
				}
				if(isUniqeword){
					System.out.println(arr[i]);
					if(inputList.contains(arr[i])){
						inputList.remove(arr[i].toString());
					}
					inputList.add(0,arr[i]);
					break;
				}
			}
		}
		System.out.println("Input : " + inputList);
		
		
		if(inputList != null && inputList.size() > 0){
			for(int i=0; i<inputList.size(); i++){
				boolean isUnique = true;
				for(int j=0; j<inputList.size(); j++){
					if(i == j){
						continue;
					}
					if(!inputList.get(i).isEmpty() && !inputList.get(j).isEmpty()){
						if(inputList.get(i).toLowerCase().toCharArray()[inputList.get(i).length()-1] == inputList.get(j).toLowerCase().toCharArray()[0]){
							System.out.println(inputList.get(i) + " - " + inputList.get(j));
							isUnique = false;
							if(!output.contains(inputList.get(i))){
								output.add(inputList.get(i));
							}
							if(!output.contains(inputList.get(j))){
								output.add(inputList.get(j));
							}
						}
					}
				}
				if(isUnique){
					if(!uniqueList.contains(inputList.get(i))){
						uniqueList.add(inputList.get(i));
					}
				}
			}
			if(uniqueList != null && uniqueList.size() > 0){
				if(!output.contains(uniqueList.get(0))){
					output.add(0, uniqueList.get(0));
				}
			}
			if(output != null && output.size() > 0){
				for(int i=0; i<output.size(); i++){
					if(i != output.size()-1){
						System.out.print(output.get(i)  + ", ");
					}else{
						System.out.print(output.get(i));
					}
				}
			}
		}
	}

}
