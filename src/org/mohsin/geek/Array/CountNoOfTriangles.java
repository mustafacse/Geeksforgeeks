package org.mohsin.geek.Array;

import java.util.Arrays;

public class CountNoOfTriangles {

	public static int countTriangle(int arr[]){
		
		int count = 0;
		Arrays.sort(arr);
		
		for(int i = 0;i < arr.length-2;++i){
			int k = i+2;
			for(int j = i+1;j < arr.length;++j){
				while(k < arr.length && arr[i]+arr[j] > arr[k])
					++k;
				
				count += (k-j-1);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int arr[] =   {10, 21, 22, 100, 101, 200, 300};
		System.out.println(countTriangle(arr));

	}

}
