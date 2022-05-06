/**
 * 
 */
package com.alok.algoexpert.io.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Alok Soni
 *
 */
//[1, 0, 0, 0, 0, 0]
//[0, 0, 0, 1, 1, 1]
//[0, 0, 0, 0, 1, 0]
//[1, 1, 0, 0, 1, 0]
//[1, 0, 0, 0, 0, 0]
//[1, 0, 0, 0, 0, 1]

public class RemoveIslands {
	public static void main(String[] args) {
		int[][] input =
		        new int[][] {
		          {1, 0, 0, 0, 0, 0},
		          {0, 1, 0, 1, 1, 1},
		          {0, 0, 1, 0, 1, 0},
		          {1, 1, 0, 0, 1, 0},
		          {1, 0, 1, 1, 0, 0},
		          {1, 0, 0, 0, 0, 1},
		        };
		int[][] result = removeIslands(input);
		for(int[] matrix : result) {
			System.out.println(Arrays.toString(matrix));
		}		
	}

	//Time - O(wh) Space - O(wh)
	//where w is the width(no of rows) of the matrix and h is the heigth(no of columns) of matrix 
	public static int[][] removeIslands(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return matrix;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[i].length - 1) {
					if (matrix[i][j] == 1) {
						findConnectedBorder(matrix, i, j);
					}
				}
			}
		}
		for(int[] m: matrix) {
			for(int i=0; i<m.length; i++) {
				if(m[i] == 2) {
					m[i] = 1;
				}else if(m[i] == 1) {
					m[i] = 0;
				}
			}
		}
				
		return matrix;
	}

	private static void findConnectedBorder(int[][] matrix, int i, int j){
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {i, j});
		while(!stack.isEmpty()) {
			int[] current = stack.pop();
			int row = current[0];
			int column = current[1];
			
			if(matrix[row][column] == 1) {
				int[][] neighbours = getNeighbors(matrix, row, column);
				for(int[] neighbour : neighbours) {
					int r = neighbour[0];
					int c = neighbour[1];
					if(matrix[r][c] != 1) {
						continue;
					}
					stack.push(neighbour);
				}
			}
			matrix[row][column] = 2;
		}
	}
	
	private static int[][] getNeighbors(int[][] matrix, int row, int column){
		ArrayList<int[]> temp = new ArrayList<>();
		if(row-1 >= 0) {
			temp.add(new int[] {row-1, column});	// Up
		}
		
		if(column+1 < matrix[row].length) {
			temp.add(new int[] {row, column+1});	// Right
		}
		
		if(row+1 < matrix.length) {
			temp.add(new int[] {row+1, column}); 	//Down
		}
		
		if(column-1 >= 0) {
			temp.add(new int[] {row, column-1}); 	//Left
		}
		
		int[][] neighbours = new int[temp.size()][2];
		for(int i=0; i<temp.size(); i++) {
			neighbours[i] = temp.get(i);
		}
		return neighbours;
	}
}
