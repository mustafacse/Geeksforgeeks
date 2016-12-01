package org.mohsin.geek.DP;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public static int ceil(int arr[],int lis[],int l,int r,int key){
		int mid = 0;
		while(r-l > 1){
			mid = (l+(r-l)/2);
			if(arr[lis[mid]] >= key)
				r = mid;
			else
				l = mid;
		}
		return r;
	}
	
	public static int LIS2(int arr[]){
		
		int lis[] = new int[arr.length];
		int len = 1;
		lis[0] = 0;
		for(int i = 0;i < arr.length;++i){
			if(arr[i] < arr[lis[0]]){
				lis[0] = i;
			}else if(arr[i] > arr[lis[len-1]]){
				lis[len++] = i;
			}else
			{
				int pos = ceil(arr,lis,-1,len-1,arr[i]);
				lis[pos] = i;
			}
		}
		return len;
	}
	
	public static int LIS(int arr[]){
		
		int lis[] = new int[arr.length];
		
		Arrays.fill(lis, 1);
		
		for(int i = 1;i < arr.length;++i){
			for(int j = 0;j < i;++j){
				if(arr[i] > arr[j] && lis[i] < lis[j]+1)
					lis[i] = lis[j]+1;
			}
		}
		
		int max = lis[0];
		for(int i = 1;i < lis.length;++i){
			if(max < lis[i])
				max = lis[i];
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(LIS(arr));
		System.out.println(LIS2(arr));
	}

}
