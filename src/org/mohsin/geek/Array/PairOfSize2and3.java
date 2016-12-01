package org.mohsin.geek.Array;

public class PairOfSize2and3 {

	public static int noOfPairs(int arr[]){
		
		int count[] = new int[3];
		
		for(int i = 0;i < arr.length;++i)
			++count[arr[i]%3];
		
		int res = count[0]*(count[0]-1)/2;
		res += count[1]*count[2];
		
		for(int i = 0;i < 3;++i)
			res += (count[i]*(count[i]-1)*(count[i]-2))/6;
		
		res += count[0]*count[1]*count[2];
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {3, 6, 7, 2, 9};
		System.out.println(noOfPairs(arr));

	}

}
