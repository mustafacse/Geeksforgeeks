package org.mohsin.geek.Array;

public class SmallestPosCanNotBeRepresent {

	public static int smallestPos(int arr[]){
		
		int res = 1;
		for(int i = 0;i < arr.length && arr[i] <= res;++i)
			res += arr[i];
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int arr1[] = {1, 3, 4, 5};
		System.out.println(smallestPos(arr1));

	}

}
