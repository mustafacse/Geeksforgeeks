package org.mohsin.geek.Array;

public class MaximumAvgSubArrayOfSizeK {

	public static int maxSize(int arr[],int k){
		
		int sum = 0;
		for(int i = 0;i < k;++i)
			sum += arr[i];
		
		int maxSum = sum,end = k-1;
		for(int i = k;i < arr.length;++i){
			sum += (arr[i]-arr[i-k]);
			if(sum > maxSum){
				maxSum = sum;
				end = i;
			}
		}
		return end-k+1;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 12, -5, -6, 50, 3};
	    int k = 4;
	    System.out.println(maxSize(arr, k));

	}

}
