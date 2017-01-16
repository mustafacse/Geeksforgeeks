package org.mohsin.geek.DP;

public class MinimumCoinsToReachGivenSum {

	
	public static int minCoins(int coins[],int m,int n){
		
		if(n == 0)
			return 0;
		
		int res = Integer.MAX_VALUE;
		
		for(int i = 0;i < m;++i){
			if(coins[i] <= n){
				int temp = minCoins(coins, m, n-coins[i]);
				if(temp != Integer.MAX_VALUE && temp+1 < res)
					res = temp+1;
			}
		}
		
		return res;
	}
	
	
	public static int dp(int coins[],int m,int n){
		
		int res[] = new int[n+1];
		
		res[0] = 0;
		
		for(int i = 1;i <= n;++i){
			res[i] = Integer.MAX_VALUE;
			
			for(int j = 0;j < m;++j){
				if(coins[j] <= i){
					int temp = res[i-coins[j]];
					if(temp != Integer.MAX_VALUE && temp + 1 < res[i])
						res[i] = temp+1;
				}
			}
		}
		
		return res[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] =  {9, 6, 5, 1};
		int m = coins.length;
		int n = 11;
		
		System.out.println(minCoins(coins, m, n));
		System.out.println(dp(coins, m, n));
	}

}
