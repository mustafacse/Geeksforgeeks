package org.mohsin.geek.Array;

public class MaximumSumOfRotations {

	public static int max(int arr[]){
		
		int arrSum = 0;
		int currSum = 0;
		for(int i = 0;i < arr.length;++i)
		{
			arrSum += arr[i];
			currSum += (i*arr[i]);
		}
		
		int maxSum = currSum;
		
		for(int i = 1;i < arr.length;++i){
			currSum = currSum +arrSum-(arr.length*(arr[arr.length-i]));
			if(currSum > maxSum)
				maxSum = currSum;
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		
		 int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		 System.out.println(max(arr));
	}

}
