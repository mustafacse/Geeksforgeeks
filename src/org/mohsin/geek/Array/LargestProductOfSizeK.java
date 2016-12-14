package org.mohsin.geek.Array;

public class LargestProductOfSizeK {

	public static int maxProduct(int arr[],int k){
		
		int maxSoFar = 0;
		int prod = 1;
		for(int i = 0;i < k;++i){
			prod *= arr[i];
		}
		
		maxSoFar = prod;
		for(int i = k;i < arr.length;++i){
			prod *= arr[i];
			prod /= arr[i-k];
			if(prod > maxSoFar)
				maxSoFar = prod;
		}
		
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 5, 9, 8, 2, 4, 1, 8, 1, 2};
		int k = 4;
		System.out.println(maxProduct(arr, k));

	}

}
