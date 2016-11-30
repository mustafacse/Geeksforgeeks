package org.mohsin.geek.Array;

public class LongestIncreasingSequence {

	public static int ceilIndex(int arr[],int l,int r,int tailIndex[], int key){
		
		int mid = 0;
		while((r-l) > 1){
			mid = (l+(r-l)/2);
			if(arr[tailIndex[mid]] >= key)
				r = mid;
			else
				l = mid;
		}
		return r;
	}
	
	
	public static void lis(int arr[]){
		
		int tailIndex[] = new int[arr.length];
		int prevIndex[] = new int[arr.length];
		
		for(int i = 0;i < arr.length;++i){
			tailIndex[i] = 0;
			prevIndex[i] = -1;
		}
		
		int len = 1;
		for(int i = 1;i < arr.length;++i){
			if(arr[i] < arr[tailIndex[0]]){
				tailIndex[0] = i;
			}else if(arr[i] > arr[tailIndex[len-1]]){
				prevIndex[i] = tailIndex[len-1];
				tailIndex[len++] = i;
			}else{
				int pos = ceilIndex(arr,-1,len-1,tailIndex,arr[i]);
				prevIndex[i] = tailIndex[pos];
				tailIndex[pos] = i;
			}
		}
		
		for(int i = tailIndex[len-1];i >= 0;i = prevIndex[i])
			System.out.print(arr[i]+" ");
		
	}
	public static void main(String[] args) {
		
		 int arr[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		 lis(arr);

	}

}
