package org.mohsin.geek.DP;

public class MaximumIncreasingSubSequence {

	public static int dp(int arr[]){
		
		int mis[] = new int[arr.length];
		
		for(int i = 0;i < arr.length;++i)
			mis[i] = arr[i];
		
		for(int i = 1; i < arr.length;++i){
			for(int j = 0;j < i;++j){
				if(arr[j] < arr[i] && mis[i] < mis[j]+arr[i])
					mis[i] = mis[j]+arr[i];
			}
		}
		
		int maxVal = mis[0];
		for(int i = 1;i < arr.length;++i)
			maxVal = Integer.max(maxVal, mis[i]);
		
		return maxVal;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int arr[] = {1, 101, 2, 3, 100, 4, 5};
		 System.out.println(dp(arr) );
	}

}
