package org.mohsin.geek.Hash;

import java.util.HashSet;

public class LargestContiguosSubArray {

	public static int maxLenSubArray(int arr[]){
		
		int maxLen = Integer.MIN_VALUE;
		for(int i = 0;i < arr.length-1;++i){
			
			int min = arr[i];
			int max = arr[i];
			HashSet<Integer> set = new HashSet<>();
			set.add(arr[i]);
			for(int j = i+1;j < arr.length;++j){
				if(set.contains(arr[j]))
					break;
				
				set.add(arr[j]);
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
				if((max-min) == (j-i) && (max-min+1 > maxLen) )
				{
					maxLen = max-min+1;
				}
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		
		int arr[] =  {10, 12, 12, 10, 10, 11, 10};
	       System.out.println("Length of the longest contiguous subarray is " +
	                           maxLenSubArray(arr));
	}

}
