package org.mohsin.geek.Array;

import java.util.Arrays;

public class PythagoreanTriplet {

	public static boolean isPresent(int arr[]){
		
		for(int i = 0;i < arr.length;++i){
			arr[i] = (int) Math.pow(arr[i], 2);
		}
		
		Arrays.sort(arr);
		
		for(int i = arr.length-1;i >= 2;--i){
			int j = 0;
			int k = i-1;
			while(j < k){
				if(arr[i] == arr[j]+arr[k])
					return true;
				if(arr[i] > arr[j]+arr[k])
					++j;
				else
					--k;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]){
		
		int arr[] = {3, 1, 4, 6, 5};
		if(isPresent(arr))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
