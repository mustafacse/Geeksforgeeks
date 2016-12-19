package org.mohsin.geek.Array;

import java.util.Arrays;

public class MaximumSumOfPairsWithSpecificDiff {

	public static int maxSum(int arr[],int k){
		
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = arr.length-1;i > 0;--i){
			
			if(arr[i]-arr[i-1] < k){
				sum += (arr[i]+arr[i-1]);
				--i;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		 int arr[] = {3, 5, 10, 15, 17, 12, 9};
		 int k = 4;
		 
		 System.out.println(maxSum(arr, k));

	}

}
