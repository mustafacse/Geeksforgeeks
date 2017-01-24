package org.mohsin.geek.Array;

public class MaxLengthSubArraysForGivenSum {

	public static int maxLengthSubArrays(int arr[],int k){
		
		int prefixSum[] = new int[arr.length+1];
		
		prefixSum[0] = 0;
		
		for(int i = 0;i <= arr.length-1;++i){
			prefixSum[i+1] = prefixSum[i]+arr[i];
		}
		
		return binarySearch(prefixSum,k);
	}
	
	public static int binarySearch(int prefixSum[],int k){
		
		int n = prefixSum.length;
		
		int left = 1;
		int right = n-1;
		int ans = -1;
		while(left <= right){
			
			int mid = (left+(right-left)/2);
			int i = 0;
			
			for( i = mid;i <= n-1;++i)
				if(prefixSum[i]-prefixSum[i-mid] > k)
					break;
			
			if(i == n)
			{
				left = mid+1;
				ans = mid;
			}else{
				right = mid-1;
			}
		}
		
		return ans;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4};
		int k = 8;
		
		System.out.println(maxLengthSubArrays(arr, k));
	}

}
