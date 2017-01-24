package org.mohsin.geek.Array;


public class MaximumSumSubArray {

	public static int maxSum(int arr[]){
		
		int fw[] = new int[arr.length];
		int bw[] = new int[arr.length];
		
		int currMax = 0,maxSoFar = 0;
		
		currMax = maxSoFar = fw[0] = arr[0];
		
		for(int i = 1;i < arr.length;++i){
			currMax = Integer.max(currMax+arr[i], arr[i]);
			maxSoFar = Integer.max(currMax, maxSoFar);
			fw[i] = currMax;					
		}
		
		currMax = maxSoFar = bw[arr.length-1] = arr[arr.length-1];
		
		for(int i = arr.length-2;i >= 0;--i){
			currMax = Integer.max(currMax+arr[i], arr[i]);
			maxSoFar = Integer.max(maxSoFar, currMax);
			bw[i] = currMax;
		}
		
		int res = 0;
		for(int i = 1;i < arr.length-1;++i){
			res = Integer.max(res, fw[i-1]+bw[i+1]);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, -4, 5};
		System.out.println(maxSum(arr));
	}

}
