package org.mohsin.geek.DP;

public class MatrixChainMultilication {

	public static int chainMultiplication(int arr[],int i,int j){
		if(i == j)
			return 0;
		
		int res = Integer.MAX_VALUE;
		int cost = 0;
		for(int k = i; k < j;++k){
			cost = chainMultiplication(arr, i, k)+chainMultiplication(arr, k+1, j)+
					arr[i-1]*arr[k]*arr[j];
			if(cost < res)
				res = cost;
		}
		return cost;
	}
	
	public static int dp(int arr[]){
		
		int n = arr.length;
		int table[][] = new int[n][n];
		
		for(int  i= 0;i < n;++i)
			table[i][i] = 0;
		
		for(int len = 2;len < n;++len){
			for(int i = 1;i < n-len+1;++i){
				int j = i+len-1;
				table[i][j] = Integer.MAX_VALUE;
				for(int k = i;k < j;++k){
					int q = table[i][k]+table[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(q < table[i][j])
						table[i][j] = q;
				}
			}
		}
		return table[1][n-1];
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4};
		
		System.out.println(chainMultiplication(arr, 1, arr.length-1));
		System.out.println(dp(arr));

	}

}
