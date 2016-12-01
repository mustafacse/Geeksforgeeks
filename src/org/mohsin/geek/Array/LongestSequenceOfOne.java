package org.mohsin.geek.Array;

public class LongestSequenceOfOne {

	public static int longestSeq(int arr[]){
		
		int prevZero = -1,prevOfPrevZero = -1;
		int maxLen = 0;
		int index = -1;
		
		for(int curr = 0;curr < arr.length;++curr)
		{
			if(arr[curr] == 0){
				if(curr-prevOfPrevZero > maxLen)
				{
					maxLen = curr-prevOfPrevZero;
					index = prevZero;
				}
				prevOfPrevZero = prevZero;
				prevZero = curr;
			}
		}
		
		if(arr.length - prevOfPrevZero > maxLen)
			index = prevZero;
		
		return index;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		System.out.println(longestSeq(arr));
	}

}
