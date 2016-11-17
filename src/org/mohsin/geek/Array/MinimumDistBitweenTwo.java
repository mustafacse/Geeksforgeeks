package org.mohsin.geek.Array;

public class MinimumDistBitweenTwo {

	
	public static int minDist(int arr[],int a,int b){
		int min = Integer.MAX_VALUE;
		int prev = -1;
		int i = 0;
		for(;i < arr.length;++i){
			if(arr[i] == a || arr[i] == b){
				prev = i;
				break;
			}
		}
		
		if(i == arr.length)
			return -1;
		
		for(;i < arr.length;++i){
			if(arr[i] == a || arr[i] == b){
				if(arr[i] != arr[prev] && i-prev < min)
				{
					min = i-prev;
					prev = i;
				}
				else
					prev = i;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		System.out.println(minDist(arr, 3, 6));
	}

}
