package org.mohsin.geek.Array;

public class MinFlipsOfTwoBinaryArrays {

	public static int minFlips(int arr1[],int arr2[],int arr3[],int p,int q){
		
		int flip = 0;
		
		for(int i = 0;i < arr1.length;++i){
			if((arr1[i]^arr2[i]) != arr3[i])
				++flip;
		}
		return flip <= (p+q) ? flip : -1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = { 1, 0, 1, 1, 1, 1, 1 };
	    int arr2[] = { 0, 1, 1, 1, 1, 0, 0 };
	    int arr3[] = { 1, 1, 1, 1, 0, 0, 1 };
	    int p = 2, q = 4;
	    
	    System.out.println(minFlips(arr1, arr2, arr3, p, q));
	}

}
