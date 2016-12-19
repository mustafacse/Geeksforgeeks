package org.mohsin.geek.Array;

public class MaxXor {

	public static int sum(int arr[],int k){
		
		int xor = 0;
		int max = 0;
		
		for(int i = 0;i < k;++i)
			xor ^= arr[i];
		
		max = xor;
		
		for(int i = k;i < arr.length;++i){
			
			xor ^= arr[i-k];
			xor ^= arr[i];
			
			if(max < xor)
				max = xor;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {2, 5, 8 ,1 , 1 ,3} ;
	    int k = 3;
	    
	    System.out.println(sum(arr, k));

	}

}
