package org.mohsin.geek.Array;

public class SumOfSubSetDifferences {

	public static int sumF(int arr[]){
		
		int sum = 0;
		
		for(int i = 0;i < arr.length;++i)
		{
			sum += (arr[i]*Math.pow(2, arr.length-i-1));
		}
		
		return sum;
	}
	
	public static int sumL(int arr[]){
		
		int sum = 0;
		
		for(int i = 0;i < arr.length;++i){
			sum += (arr[i]*Math.pow(2, i));
		}
		
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		 int S[] = {5, 2, 9, 6};
		 
		 System.out.println(sumL(S)-sumF(S));

	}

}
