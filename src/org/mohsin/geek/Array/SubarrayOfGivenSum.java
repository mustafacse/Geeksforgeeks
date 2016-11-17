package org.mohsin.geek.Array;


public class SubarrayOfGivenSum {

	public static void subArray(int arr[],int x){
		
		int sum = arr[0];
		int start = 0,end = 1;
		while(end < arr.length){
			while(sum > x && start < end){
				sum -= arr[start++];
			}
			
			if(sum == x){
				System.out.println("Found between "+start+" and "+(end-1));
				return;
			}
			
			sum += arr[end++];
		}
		
		System.out.println("NOT FOUND");
	}
	
	public static void main(String[] args) {
	
		int arr[] = {1, 4, 20, 3, 10, 5};
		subArray(arr, 33);
	}

}
