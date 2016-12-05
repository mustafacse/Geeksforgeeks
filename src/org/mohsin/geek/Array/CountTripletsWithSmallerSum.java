/**
 * 
 */
package org.mohsin.geek.Array;

import java.util.Arrays;

/**
 * @author mohsin
 *
 */
public class CountTripletsWithSmallerSum {

	public static int countTriplets(int arr[],int sum){
		
		Arrays.sort(arr);
		int ans = 0;
		for(int i = 0;i < arr.length-2;++i){
			int j = i+1,k = arr.length-1;
			while(j < k){
				if(arr[i]+arr[j]+arr[k] >= sum)
					--k;
				else{
					ans += (k-j);
					++j;
				}
			}
		}
		return ans;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {5, 1, 3, 4, 7};
		System.out.println(countTriplets(arr, 12));

	}

}
