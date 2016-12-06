package org.mohsin.geek.Array;

import java.util.Arrays;

public class MinimizeMaxDiffBwHeights {

	public static int minDiff(int heights[],int k){
		
		Arrays.sort(heights);
		
		int max = heights[heights.length-1];
		int min = heights[0];
		
		if(k >= max-min)
			return (max-min);
		
		heights[0] += k;
		heights[heights.length-1] -= k;
		
		max = Math.max(heights[0], heights[heights.length-1]);
		min = Math.min(heights[0], heights[heights.length-1]);
		
		for(int j = 1;j < heights.length-1;++j){
			if(heights[j] < min)
				heights[j] += k;
			else if(heights[j] > max)
				heights[j] -= k;
			else if(heights[j] - min > max - heights[j])
				heights[j] -= k;
			else
				heights[j] += k;
			
			max = Math.max(heights[j], max);
			min = Math.min(heights[j], min);
		}
		
		return max-min;
		
	}
	
	public static void main(String[] args) {
		 int arr[] = {1, 15, 10} ;
		 
		 System.out.println(minDiff(arr, 6));

	}

}
