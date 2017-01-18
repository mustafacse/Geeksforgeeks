package org.mohsin.geek.DP;

public class MinimumJumpsToReachEnd {

	public static int recursive(int arr[],int l,int h){
		
		if(l == h)
			return 0;
		if(arr[l] == 0)
			return Integer.MAX_VALUE;
		
		int res = Integer.MAX_VALUE;
		int jumps = 0;
		
		for(int i = l+1;i <= h && i <= l+arr[l];++i){
			jumps = recursive(arr, i, h);
			if(jumps != Integer.MAX_VALUE && jumps+1 < res)
				res = jumps+1;
		}
		return res;
	}
	
	public static int dp(int arr[]){
		
		int n = arr.length;
		
		int jumps[] = new int[n];
		
		jumps[0] = 0;
		
		for(int i = 1;i < n;++i){
			jumps[i] = Integer.MAX_VALUE;
			for(int j = 0;j < i;++j){
				if(jumps[j] != Integer.MAX_VALUE && j+arr[j] >= i){
					jumps[i] = Integer.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		return jumps[n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(recursive(arr, 0, arr.length-1));
		System.out.println(dp(arr));
	}

}
