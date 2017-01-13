package org.mohsin.geek.DP;

public class EggDroppingPuzzle {

	public static int recursive(int n,int k){
		if(k == 0 || k == 1)
			return k;
		if(n == 1)
			return k;
		
		int min = Integer.MAX_VALUE;
		
		for(int x = 1;x <= k;++x){
			
			int res = Integer.max(recursive(n-1, x-1), recursive(n, k-x));
			if(res < min)
				min = res;
		}
		
		return min+1;
	}
	
	public static int dpSolution(int n,int k){
		
		int dp[][] = new int[n+1][k+1];
		
		for(int i = 1;i <= n;++i){
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		
		for(int j = 1;j <= k;++j){
			dp[1][j] = j;
		}
		
		int res = 0;
		
		for(int i = 2;i <= n;++i){
			for(int j = 2;j <= k;++j){
				dp[i][j] = Integer.MAX_VALUE;
				for(int x = 1;x <= j;++x){
					res = Integer.max(dp[i-1][x-1],dp[i][j-x])+1;
					if(res < dp[i][j])
						dp[i][j] = res;
				}
			}
		}
		
		return dp[n][k];
	}
	public static void main(String[] args) {
		
		int n = 2,k = 10;
		
		System.out.println(recursive(n, k));
		System.out.println(dpSolution(n, k));

	}

}
