package org.mohsin.geek.Array;

public class NoThreeAreConsecutive {

	public static int maxSum(int arr[]){
		
		int sum[] = new int[arr.length];
		
		sum[0] = arr[0];
		sum[1] = arr[0]+arr[1];
		sum[2] = Math.max(sum[1], arr[1]+arr[2]);
		
		for(int i = 3;i < arr.length;++i){
			sum[i] = Math.max(sum[i-1], Math.max(sum[i-2]+arr[i], sum[i-3]+arr[i-1]+arr[i]));
		}
		
		return sum[arr.length-1];
	}
	
	public static void main(String[] args) {
		
		int arr[] = {3000, 2000, 1000, 3, 10};
		System.out.println(maxSum(arr));
	}

}
