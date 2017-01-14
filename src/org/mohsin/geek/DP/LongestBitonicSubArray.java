package org.mohsin.geek.DP;

import java.util.Arrays;

public class LongestBitonicSubArray {

	public static int dp(int arr[]){
		
		int lis[] = new int[arr.length];
		int lds[] = new int[arr.length];
		
		Arrays.fill(lis, 1);
		Arrays.fill(lds, 1);
		
		for(int i = 1;i < arr.length;++i){
			for(int j = 0;j < i;++j){
				if(arr[j] < arr[i] && lis[i] < lis[j]+1)
					lis[i] = lis[j]+1;
			}
		}
		
		for(int i = arr.length-2;i >= 0;--i){
			for(int j = arr.length-1;j > i;--j){
				if(arr[j] < arr[i] && lds[i] < lds[j]+1)
					lds[i] = lds[j]+1;
			}
		}
		
		int res = lis[0]+lds[0]-1;
		
		for(int i = 1;i < arr.length;++i)
			res = Integer.max(res, lis[i]+lds[i]-1);
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
	              13, 3, 11, 7, 15};
		
		System.out.println(dp(arr));
	}

}
