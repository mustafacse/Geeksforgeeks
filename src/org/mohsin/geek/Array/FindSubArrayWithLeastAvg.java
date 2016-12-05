package org.mohsin.geek.Array;

public class FindSubArrayWithLeastAvg {

	public static void leastAvgWindow(int arr[],int k){
		
		int sum = 0;
		int minSum = 0;
		int i = 0;
		int start = 0;
		for(;i < k;++i){
			sum += arr[i];
		}
		minSum = sum;
		
		for(;i < arr.length;++i){
			sum += (arr[i]-arr[i-k]);
			if(sum < minSum){
				minSum = sum;
				start = (i-k+1);
			}
		}
		System.out.println(start+" "+(start+k-1));
	}
	
	public static void main(String[] args) {
		
		int arr[] = {3, 7, 90, 20, 10, 50, 40};
		int k = 3;
		leastAvgWindow(arr, k);

	}

}
