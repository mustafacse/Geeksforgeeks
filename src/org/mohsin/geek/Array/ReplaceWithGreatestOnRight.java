/**
 * 
 */
package org.mohsin.geek.Array;

import java.util.Arrays;

/**
 * @author mohsin
 *
 */
public class ReplaceWithGreatestOnRight {

	public static void replace(int arr[]){
		
		int max = arr[arr.length-1];
		arr[arr.length-1] = -1;
		
		for(int i = arr.length-2;i >= 0;--i){
			int temp = arr[i];
			arr[i] = max;
			if(max < temp)
				max = temp;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {16,17,4,3,5,2};
		replace(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
