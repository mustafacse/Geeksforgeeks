package org.mohsin.geek.Array;

public class MaximumPathSumWithDivisiblityCondition {

	public static void maxPath(int arr[]){
		
		int n = arr.length;
		
		int dp[] = new int[n];
		int max = 0;
		
		for(int i = 0;i < n;++i){
			
			dp[i] = arr[i];
			max = 0;
			
			for(int j = 1;j <= Math.sqrt(i+1);++j){
				if((i+1)%j == 0 && (i+1) != j){
					if(dp[j-1] > max)
						max = dp[j-1];
					if(dp[(i+1)/j-1] > max && j != 1)
						max = dp[(i+1)/j-1];
				}
			}
			dp[i] += max;
		}
		
		for(int i = 0;i < n;++i)
			System.out.print(dp[i]+" ");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 3, 1, 4, 6, 5 };
		maxPath(arr);
	}

}
