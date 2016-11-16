package org.mohsin.geek.Array;

public class EquilibriumIndex {

	public static int getIndex(int arr[])
	{
		int sum = 0;
		int leftSum = 0;
		for(int i = 0;i < arr.length;++i){
			sum += arr[i];
		}
		
		for(int i = 0;i < arr.length;++i){
			sum -= arr[i];
			if(sum == leftSum) return i;
			leftSum += arr[i];
		}
		
		return -1;
	}
	
	public static void main(String args[]){
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println(getIndex(arr));
	}
}
