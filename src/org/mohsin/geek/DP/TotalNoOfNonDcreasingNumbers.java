package org.mohsin.geek.DP;

public class TotalNoOfNonDcreasingNumbers {

	public static int optimized(int n){
		
		int dp[][] = new int[10][n+1];
		
		for(int i = 1;i < 10;++i)
			dp[i][1] = 1;
		
		for(int digit = 0;digit < 10;++digit){
			for(int len = 2;len <= n;++len){
				for(int x = 0;x <= digit;++x)
					dp[digit][len] += dp[x][len-1];
			}
		}
		
		int res = 0;
		for(int i = 0;i < 10;++i)
			res += dp[i][n];
		
		return res;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		System.out.println(optimized(n));
	}

}
