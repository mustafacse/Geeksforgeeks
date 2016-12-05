package org.mohsin.geek.Array;

public class NoOfZeroesToBeFlipped {

	public static void flip(int arr[],int m){
		
		int wL = 0,wR = 0;
		int zeroCount = 0;
		int maxLength = 0;
		int start = 0;
		while(wR < arr.length){
			if(zeroCount <= m){
				if(arr[wR] <= m){
					if(arr[wR] == 0)
						++zeroCount;
					++wR;
				}
			}
			if(zeroCount > m){
				if(arr[wL] == 0)
					--zeroCount;
				++wL;
			}
			if(wR-wL > maxLength){
				maxLength = wR-wL;
				start = wL;
			}
		}
		
		for(int i = 0;i < maxLength;++i){
			if(arr[start+i] == 0){
				System.out.print(start+i+" ");
			}
		}
	}
	
	public static void main(String args[]){
		
		int  arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
		flip(arr, 2);
	}
}
