/**
 * 
 */
package org.mohsin.geek.Array;

/**
 * @author mohsin
 *
 */
public class MaximumRepeatingNumber {

	public static int findNumber(int arr[],int k){
		
		int max = 0;
		int result = 0;
		for(int i = 0;i < arr.length;++i){
			
			arr[arr[i]%k] += k;
		}
		
		for(int i = 0;i < arr.length;++i)
		{
			if(arr[i] > max)
			{
				max = arr[i];
				result = i;
			}
		}
		
		for(int i = 0;i < arr.length;++i)
			arr[i] %= k;
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {2,3,3,5,3,4,1,7};
		System.out.println(findNumber(arr, 8));

	}

}
