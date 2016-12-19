package org.mohsin.geek.Array;

import java.util.Arrays;

public class SumOfMaximumElementsOfAllSubsets {

	public static int maxSum(int arr[]){
		
		Arrays.sort(arr);
		
		int sum = arr[arr.length-1];
		for(int i = arr.length-2;i >= 0;--i)
			sum = 2*sum + arr[i];
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {3,2,5};
		System.out.println(maxSum(arr));

	}

}
