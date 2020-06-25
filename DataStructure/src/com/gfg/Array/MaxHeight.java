package com.gfg.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Height {
	int feet;
	int inches;
	public Height(int ft, int inc)
	{
	    feet = ft;
	    inches = inc;
	}
}

// function must return the maximum Height
// return the height in inches
class MaxHeight
{
	public static void main(String[] args) {
		Height[] height = new Height[4];
		height[0]  = new Height(3, 5);
		height[1] = new Height(7, 9);
		height[2] = new Height(5, 6);
		height[3] = new Height(5, 5);
		int maxHeight = findMax(height, 2);
		System.out.println("Max Height : " + maxHeight);
	}
	
    public static int findMax(Height arr[], int n)
    {
       int height = 0;
       int maxHeight = 0;
       for(int i=0; i<n; i++){
           height = 12*(arr[i].feet) + arr[i].inches;
           if(maxHeight < height){
               maxHeight = height;
           }
       }
       return maxHeight;
    }
    
}
