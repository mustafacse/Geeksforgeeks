package org.mohsin.geek.Array;

public class ThreeSortedElementInLinearTime {

	public static void seq(int arr[]){
		
		int small = Integer.MAX_VALUE;
		int large = Integer.MAX_VALUE;
		
		int i = 0;
		for(;i < arr.length;++i){
			if(arr[i] <= small)
				small = arr[i];
			else if(arr[i] <= large)
				large = arr[i];
			else
				break;
		}
		
		if(i == arr.length)
			return;
		
		for(int j = 0;j < i;++j){
			if(arr[j] < large){
				small = arr[j];
				break;
			}
		}
		
		System.out.println(small+" "+large+" "+arr[i]);
	}
	
	public static void main(String[] args) {
		
		 int arr[] = {5, 7, 4, 8};
		 seq(arr);
	}

}
