package org.mohsin.geek.Array;

public class NoOfZeroes {

	public static int lastIndexOfOne(int arr[],int start,int end){
		
		if(start > end) 
			return -1;
		
		int mid = (start+(end-start)/2);
		if(mid == arr.length-1 || arr[mid+1] == 0 && arr[mid] == 1)
			return mid;
		if(arr[mid] >= 1)
			return lastIndexOfOne(arr, mid+1, end);
		else
			return lastIndexOfOne(arr, start, mid-1);
	}
	
	public static int countZero(int arr[]){
		
		int index = lastIndexOfOne(arr, 0, arr.length-1);
		if(index == -1)
			return arr.length;
		return arr.length-index-1;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 1, 1, 1, 0, 0};
		int arr2[] = {0,0,0};
		int arr3[] = {1,1,1,1,1,1};
		
		System.out.println(countZero(arr));
		System.out.println(countZero(arr2));
		System.out.println(countZero(arr3));
	}

}
