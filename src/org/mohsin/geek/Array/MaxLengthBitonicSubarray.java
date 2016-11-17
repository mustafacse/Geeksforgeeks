package org.mohsin.geek.Array;

public class MaxLengthBitonicSubarray {

	public static int maxLen(int arr[]){
		
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		
		left[0] = 1;
		for(int i = 1;i < arr.length;++i){
			left[i] = arr[i] > arr[i-1] ? left[i-1]+1 : 1;
		}
		
		right[arr.length-1] = 1;
		for(int i = arr.length-2;i >= 0;i--){
			right[i] = arr[i] > arr[i+1] ? right[i+1]+1 : 1;
		}
		/*
		for(int i = 0;i < arr.length;++i)
			System.out.print(left[i]+" ");
		
		System.out.println();
		
		for(int i = 0;i < arr.length;++i)
			System.out.print(right[i]+" ");*/
		
		int max = Integer.MIN_VALUE;
		for(int i = 0;i < arr.length;++i){
			if(left[i]+right[i]-1 > max)
				max = left[i]+right[i]-1;
		}
		return max;
	}
	
	
	public static void main(String[] args) {
	
		int arr[] = {12, 4, 78, 90, 45, 23};
		System.out.println(maxLen(arr));
	}

}
