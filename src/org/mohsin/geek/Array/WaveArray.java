package org.mohsin.geek.Array;

import java.util.Arrays;

public class WaveArray {

	public static void wave(int arr[]){
		
		Arrays.sort(arr);
		boolean flag = false;
		for(int i = 0;i < arr.length-1;++i){
			if(!flag){
				if(arr[i] < arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}else{
				if(arr[i] > arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			flag = !flag;
		}
	}
	
	public static void printArr(int arr[]){
		
		for(int i =0;i < arr.length;++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1,2,3,4};
		int arr2[] = {5,7,3,2,8};
		
		wave(arr1);
		wave(arr2);
		printArr(arr1);
		printArr(arr2);
	}

}
