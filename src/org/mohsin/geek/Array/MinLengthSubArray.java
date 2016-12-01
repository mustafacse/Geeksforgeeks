package org.mohsin.geek.Array;

public class MinLengthSubArray {

	public static int minLenSubArray(int arr[],int val){
		
		int currSum = arr[0];
		int start = 0,end = 1;
		int minLen = Integer.MAX_VALUE;
		
		while(end < arr.length){
			
			while(currSum > val && start < end){
				if(end-start < minLen)
					minLen = end-start;
				currSum -= arr[start++];
			}
			
			currSum += arr[end++];
		}
		
		return minLen;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 4, 45, 6, 0, 19};
		System.out.println(minLenSubArray(arr, 51));
		
		int arr2[] = {1, 10, 5, 2, 7};
		System.out.println(minLenSubArray(arr2, 9));
		
		int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		
		System.out.println(minLenSubArray(arr3, 280));

	}

}
