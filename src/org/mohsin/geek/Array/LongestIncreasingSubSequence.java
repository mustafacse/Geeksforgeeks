/**
 * 
 */
package org.mohsin.geek.Array;

/**
 * @author mohsin
 *
 */
public class LongestIncreasingSubSequence {

	public static void LIS(int arr[]){
		
		int tail[] = new int[arr.length];
		int prev[] = new int[arr.length];
		
		for(int i = 0;i < prev.length;++i)
			prev[i] = -1;
		
		int len = 1;
		tail[0] = 0;
		for(int i = 1;i < arr.length;++i){
			if(arr[i] < arr[tail[0]])
				tail[0] = i;
			else if(arr[i] > arr[tail[len-1]]){
				prev[i] = tail[len-1];
				tail[len++] = i;
			}else
			{
				int pos = ceilIndex(arr,tail,-1,len-1,arr[i]);
				prev[i] = tail[pos-1];
				tail[pos] = i;
			}
		}
		
		for(int i = tail[len-1]; i >= 0;i = prev[i])
			System.out.print(arr[i]+" ");
	}
	
	public static int ceilIndex(int arr[],int tail[],int l,int r,int key){
		
		while(r-l > 1)
		{
			int m = (l+(r-l)/2);
			if(arr[tail[m]] >= key)
				r = m;
			else
				l = m;
		}
		return r;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arr[] = {2,5,3,7,11,8,10,13,6};
		LIS(arr);

	}

}
