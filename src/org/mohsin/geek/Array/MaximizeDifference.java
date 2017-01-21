package org.mohsin.geek.Array;

public class MaximizeDifference {

	public static int maxDiff(int arr[]){
		
		int maxVal = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;
		
		for(int i = 0;i < arr.length;++i){
			
			maxVal = Integer.max(maxVal, arr[i]-i);
			minVal = Integer.min(minVal, arr[i]-i);
		}
		
		return maxVal-minVal;
	}
	
	public static void main(String ags[]){
		
		 int arr[] = {9, 15, 4, 12, 13};
		 System.out.println(maxDiff(arr));
	}
}
