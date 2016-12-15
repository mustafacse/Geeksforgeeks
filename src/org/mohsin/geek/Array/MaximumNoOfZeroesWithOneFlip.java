package org.mohsin.geek.Array;

public class MaximumNoOfZeroesWithOneFlip {

	public static int maxZeroes(int arr[]){
		
		int zeroCount = 0;
		int maxDiff = Integer.MIN_VALUE;
		int currMax = 0;
		
		for(int i = 0;i < arr.length;++i){
			
			if(arr[i] == 0)
				++zeroCount;
			
			int val = arr[i] == 1 ? 1 : -1;
			currMax = Math.max(currMax+val, val);
			maxDiff = Math.max(currMax, maxDiff);
		}

		maxDiff = Math.max(0,maxDiff);
		return zeroCount+maxDiff;
		
	}
	
	public static void main(String[] args) {
		
		int arr[] = {0, 1, 0, 0, 1, 1, 0};
		System.out.println(maxZeroes(arr));
	}

}
