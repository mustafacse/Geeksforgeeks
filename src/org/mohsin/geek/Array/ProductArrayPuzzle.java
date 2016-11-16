package org.mohsin.geek.Array;

public class ProductArrayPuzzle {

	public static void productArray(int arr[]){
		
		int res[] = new int[arr.length];
		int temp = 1;
		
		for(int i = 0;i < arr.length;++i){
			res[i] = temp;
			temp *= arr[i];
		}
		
		temp = 1;
		for(int i = arr.length-1;i >= 0;--i){
			res[i] *= temp;
			temp *= arr[i];
		}
	}
}
