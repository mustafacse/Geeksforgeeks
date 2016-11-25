/**
 * 
 */
package org.mohsin.geek.Array;

/**
 * @author mohsin
 *
 */
public class MaximumCircularSum {

	public static int kadaneAlgo(int arr[]){
		
		int maxEndingHere = 0;
		int maxSoFar = 0;
		for(int i = 0;i < arr.length;++i){
			maxEndingHere += arr[i];
			if(maxEndingHere < 0)
				maxEndingHere = 0;
			if(maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
		}
		return maxSoFar;
	}
	
	
	public static int maxSum(int arr[])
	{
		
		int maxKadane = kadaneAlgo(arr);
		
		int maxWrap = 0;
		for(int i = 0;i < arr.length;++i){
			maxWrap += arr[i];
			arr[i] = -arr[i];
		}
		
		maxWrap += kadaneAlgo(arr);
		
		return Math.max(maxKadane, maxWrap);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {11,10,-20,5,-3,-5,8,-13,10};
		System.out.println(maxSum(arr));
		
	}

}
