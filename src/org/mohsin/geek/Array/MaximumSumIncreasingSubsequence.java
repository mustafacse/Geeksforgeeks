package org.mohsin.geek.Array;

public class MaximumSumIncreasingSubsequence {

	public static int maxSum(int arr[]){
		
		int currMax = arr[0];
		int max = arr[0];
		
		for(int i = 1;i < arr.length;++i){
			if(arr[i] > arr[i-1]){
				currMax += arr[i];
			}else{
				if(currMax > max)
					max = currMax;
				currMax = arr[i];
			}
		}
		
		return Integer.max(currMax, max);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 2, 5, 1, 7};
		System.out.println(maxSum(arr));
	}

}
