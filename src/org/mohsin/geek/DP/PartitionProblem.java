package org.mohsin.geek.DP;


public class PartitionProblem {

	public static boolean isPartitionAvail(int arr[],boolean dp){
		
		int sum = 0;
		
		for(int i = 0;i < arr.length;++i)
			sum += arr[i];
		
		if(sum%2 != 0)
			return false;
		
		if(!dp)
			return recursive(arr,arr.length,sum/2);
		
		return dpSol(arr,sum/2);
		
	}
	
	public static boolean recursive(int arr[],int n,int sum){
		
		if(sum == 0)
			return true;
		if(n ==0 && sum != 0)
			return false;
		
		if(arr[n-1] > sum)
			return recursive(arr, n-1, sum);
		
		return recursive(arr, n-1, sum)||recursive(arr, n-1, sum-arr[n-1]);
	}
	
	
	public static boolean dpSol(int arr[],int sum){
		
		boolean dp[][] = new boolean[sum+1][arr.length+1];
		
		for(int i = 0;i < arr.length+1;++i)
			dp[0][i] = true;
		
		for(int j = 0;j <= sum;++j)
			dp[j][0] = false;
		
		for(int i = 1;i <= sum;++i){
			for(int j = 1;j <= arr.length;++j){
				
				if(i < arr[j-1])
					dp[i][j] = false;
				else
					dp[i][j] = dp[i-arr[j-1]][j-1] || dp[i][j-1];
			}
		}
		
		return dp[sum][arr.length];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,5,11,5};
		
		System.out.println(isPartitionAvail(arr, false));
		System.out.println(isPartitionAvail(arr, true));
	}

}
