package org.mohsin.geek.Array;

import java.util.HashMap;

public class FindNoOfPairsForGivenSum {

	public static int countPairs(int arr[],int sum){
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		int pairs = 0;
		
		for(int i = 0;i < arr.length;++i){
			int temp = sum-arr[i];
			if(hm.get(temp) != null)
				++pairs;
			else {
				hm.put(arr[i], 1);
			}
		}
		return pairs;
	}
	
	public static void main(String[] args) {
		
		 int arr[] = {1, 5, 7, -1, 5} ;
		 int sum = 6;
		 System.out.println(countPairs(arr, sum));

	}

}
