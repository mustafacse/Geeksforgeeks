package org.mohsin.geek.Array;

public class ArrayCanBeDivided {

	public static boolean isPossible(int arr[]){
		
		int sum = 0;
		for(int i = 0;i < arr.length;++i)
			sum += arr[i];
		
		int leftSum = 0;
		for(int i = 0;i < arr.length;++i){
			
			sum -= arr[i];
			if(sum == leftSum)
				return true;
			leftSum += arr[i];
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {6, -2, 3, 2, 3};
		if(isPossible(arr))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
