package org.mohsin.geek.Array;

public class MaximumDifferenceBasedOnConstraint {

	public static int maxDiff(int arr[]){
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0;i < arr.length;++i){
			max = Math.max(max, arr[i]-i);
			min = Math.min(min, arr[i]-i);
		}
		
		return max-min;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {9, 15, 4, 12, 13};
		System.out.println(maxDiff(arr));

	}

}
