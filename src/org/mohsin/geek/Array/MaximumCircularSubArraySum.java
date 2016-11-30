package org.mohsin.geek.Array;

public class MaximumCircularSubArraySum {

	public static int kadane(int arr[]){
		
		int maxSoFar = 0,maxEndingHere = 0;
		
		for(int i = 0;i < arr.length;++i){
			maxEndingHere += arr[i];
			if(maxEndingHere < 0)
				maxEndingHere = 0;
			else if(maxEndingHere > maxSoFar)
				maxSoFar = maxEndingHere;
		}
		
		return maxSoFar;
	}
	
	public static int maxCircularSum(int arr[]){
		
		int kadaneSum = kadane(arr);
		
		int sum = 0;
		for(int i = 0;i < arr.length;++i){
			sum += arr[i];
			arr[i] = -arr[i];
		}
		
		sum += kadane(arr);
		return Math.max(sum, kadaneSum);
	}
	
	public static void main(String[] args) {
	
		int arr[] = {-1,40,-14,7,6,5,-4,-1};
		System.out.println(maxCircularSum(arr));

	}

}
