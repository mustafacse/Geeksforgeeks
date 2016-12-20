package org.mohsin.geek.Array;

public class FindOnlyRepeatedElementInSortedArray {

	public static int search(int arr[],int low,int high){
		
		if(low > high)
			return -1;
		
		int mid = (low+(high-low)/2);
		if(arr[mid] != mid+1){
			if(mid > 0 && arr[mid] == arr[mid-1])
				return arr[mid];
			return search(arr, low, mid-1);
		}
		return search(arr, mid+1, high);
	}
	
	
	public static void main(String[] args) {
		
		 int  arr[] = {1, 2, 3, 3, 4, 5};
		 System.out.println(search(arr, 0, arr.length-1));

	}

}
