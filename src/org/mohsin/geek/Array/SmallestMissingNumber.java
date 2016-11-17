package org.mohsin.geek.Array;

public class SmallestMissingNumber {

	public static int smallestMissed(int arr[]){
		
		for(int i = 0;i < arr.length;++i){
			if(arr[i] < arr.length && arr[arr[i]] > 0)
				arr[arr[i]] = -arr[arr[i]];
		}
		
		for(int i = 0;i < arr.length;++i){
			if(arr[i] > 0)
				return i;
		}
		return arr.length;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {0, 1, 2, 6, 9};
		System.out.println(smallestMissed(arr));

		int  arr1[] =   {0, 1, 2, 3, 4, 5, 6, 7, 10};
		System.out.println(smallestMissed(arr1));
		
		
		
	}

}
