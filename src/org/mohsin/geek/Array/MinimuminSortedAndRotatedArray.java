package org.mohsin.geek.Array;

public class MinimuminSortedAndRotatedArray {

	public static int findPivot(int arr[],int left,int right,int n){
		
		if(left > right)
			return -1;
		if(left == right)
			return left;
		int mid = left+(right-left)/2;
		if(mid > 0 && arr[mid-1] > arr[mid])
			return mid-1;
		if(mid+1 <= right && arr[mid] > arr[mid+1])
			return mid;
		if(arr[left] < arr[mid])
			return findPivot(arr, mid+1, right, n);
		return findPivot(arr, left, mid-1, n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,5,1,2,3};
		System.out.println(findPivot(arr, 0, arr.length-1,arr.length-1));
	}

}
