package org.mohsin.geek.Array;

public class MaxProduct {

	public static int max(int arr[]){
		
		int left = 0,right = arr.length-1;
		int currProduct = 0;
		int maxProduct = Integer.MIN_VALUE;
		
		while(left < right){
			
			if(arr[left] < arr[right]){
				currProduct = arr[left]*(right-left);
				++left;
			}else{
				currProduct = arr[right]*(right-left);
				--right;
			}
			
			maxProduct = Math.max(maxProduct, currProduct);
		}
		return maxProduct;
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {8, 1, 9, 4};
		
		System.out.println(max(arr));

	}

}
