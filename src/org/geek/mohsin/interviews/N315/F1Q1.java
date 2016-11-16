package org.geek.mohsin.interviews.N315;

public class F1Q1 {

	public static int firstOccur(int arr[], int left, int right, int data) {
		if (left > right)
			return -1;
		int mid = (left + (right - left) / 2);

		if ((mid == 0 || data > arr[mid - 1]) && arr[mid] == data)
			return mid;
		else if (arr[mid] < data)
			return firstOccur(arr, mid + 1, right, data);
		else
			return firstOccur(arr, left, mid - 1, data);
	}

	public static int lastOccur(int arr[], int left, int right, int data) {
		if(left <= right){
		int mid = (left + (right - left) / 2);

		if ((mid == arr.length - 1 || data < arr[mid + 1]) && arr[mid] == data)
			return mid;
		else if (data < arr[mid])
			return lastOccur(arr, left, (mid - 1), data);
		else
			return lastOccur(arr, (mid + 1), right, data);
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 8 };
		int data = 4;
		int first = firstOccur(arr,0,arr.length-1,data);
		int last = lastOccur(arr,0,arr.length-1,data);
		System.out.println(last-first+1);

	}

}
