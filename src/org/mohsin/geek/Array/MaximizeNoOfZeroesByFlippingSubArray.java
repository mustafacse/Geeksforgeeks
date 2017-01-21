package org.mohsin.geek.Array;

public class MaximizeNoOfZeroesByFlippingSubArray {

	public static int maximize(int arr[]){
		
		int zeroCount = 0;
		int currMax = 0;
		int maxSoFar = 0;
		
		for(int i = 0;i < arr.length;++i){
			
			if(arr[i] == 0)
				++zeroCount;
			
			int val = arr[i] == 0 ? -1 : 1;
			currMax = Integer.max(val, currMax+val);
			maxSoFar = Integer.max(currMax, maxSoFar);
		}
		
		zeroCount += Integer.max(maxSoFar, 0);
		return zeroCount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
