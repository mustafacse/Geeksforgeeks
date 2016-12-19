package org.mohsin.geek.Array;

public class MaximumSumInStrictlyIncSubArray {

	public static int maxSum(int arr[]){
		
		int sum = 0;
		int currSum = arr[0];
		
		for(int i = 1;i < arr.length;++i){
			
			if(arr[i] > arr[i-1])
				currSum += arr[i];
			else{
				sum = Math.max(currSum, sum);
				currSum = arr[i];
			}
		}
		
		return Math.max(currSum,sum);
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 2, 2, 4};
		System.out.println(maxSum(arr));

	}

}
