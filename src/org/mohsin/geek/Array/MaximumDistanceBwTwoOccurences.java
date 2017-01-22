package org.mohsin.geek.Array;

import java.util.HashMap;

public class MaximumDistanceBwTwoOccurences {

	/**
	 * Max distance.
	 *
	 * @param arr the arr
	 * @return the int
	 */
	public static int maxDistance(int arr[]){
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int maxDist = 0;
		
		for(int i = 0;i < arr.length;++i){
			
			if(hm.get(arr[i]) == null)
				hm.put(arr[i],i);
			else{
				if(i-hm.get(arr[i]) > maxDist)
					maxDist = i-hm.get(arr[i]);
			}
		}
		
		return maxDist;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
		System.out.println(maxDistance(arr));

	}

}
