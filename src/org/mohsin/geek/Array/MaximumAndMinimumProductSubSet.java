package org.mohsin.geek.Array;

public class MaximumAndMinimumProductSubSet {

	public static void subSet(int arr[]){
		
		int currMax = arr[0];
		int currMin = arr[0];
		int prevMax = arr[0];
		int prevMin = arr[0];
		int maxProduct = Integer.MIN_VALUE;
		int minProduct = Integer.MAX_VALUE;
		
		for(int i = 1;i < arr.length;++i){
			
			currMax = Math.max(prevMax*arr[i], Math.max(prevMin*arr[i], arr[i]));
			currMax = Math.max(currMax, prevMax);
			
			currMin = Math.min(prevMin*arr[i], Math.min(prevMax*arr[i], arr[i]));
			currMin = Math.min(currMin, prevMin);
			
			maxProduct = Math.max(currMax, maxProduct);
			minProduct = Math.min(minProduct, currMin);
			
			prevMax = currMax;
			prevMin = currMin;
		}
		
		System.out.println(maxProduct+" "+minProduct);
	}
	
	public static void main(String[] args) {
		
		 int arr[] = {-4, -2, 3, 7, 5, 0, 1};

		 subSet(arr);
	}

}
