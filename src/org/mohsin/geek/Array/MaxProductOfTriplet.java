package org.mohsin.geek.Array;

public class MaxProductOfTriplet {

	public static int maxProduct(int arr[]){
		
		int maxA = 0,maxB = 0,maxC = 0;
		int minA = 0,minB = 0;
		
		for(int i = 0;i < arr.length;++i){
			if(arr[i] > maxA){
				maxC = maxB;
				maxB = maxA;
				maxA = arr[i];
			}
			
			else if(arr[i] > maxB){
				maxC = maxB;
				maxB = arr[i];
			}
			
			else if(arr[i] > maxC)
				maxC = arr[i];
			
			if(minA > arr[i]){
				minB = minA;
				minA = arr[i];
			}
			else if(minB > arr[i]){
				minB = arr[i];
			}
		}
		
		return Math.max(minA*minB*maxA, maxA*maxB*maxC);
	}
	
	public static void main(String[] args) {
		
		 int arr[] = { 1, -4, 3, -6, 7, 0 };
		 System.out.println(maxProduct(arr));

	}

}
