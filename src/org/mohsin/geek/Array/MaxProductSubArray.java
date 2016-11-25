/**
 * 
 */
package org.mohsin.geek.Array;

/**
 * @author mohsin
 *
 */
public class MaxProductSubArray {

	public static int maxProd(int arr[]){
		
		int maxEndingHere = 1;
		int minEndingHere = 1;
		int maxSoFar = 1;
		
		for(int i = 0;i < arr.length;++i){
			
			if(arr[i] > 0){
				maxEndingHere *= arr[i];
				minEndingHere = Math.min(minEndingHere*arr[i], 1);
			}
			else if(arr[i] < 0){
				int temp = maxEndingHere;
				maxEndingHere = Math.max(minEndingHere*arr[i], 1);
				minEndingHere = temp*arr[i];
			}else{
				maxEndingHere = minEndingHere = 1;
			}
			
			if(maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
		}
		
		return maxSoFar;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {6,-3,-10,0,2};
		System.out.println(maxProd(arr));

	}

}
