package org.mohsin.geek.DP;

public class CoingChange {

	public static int coinChange(int s[],int m,int n){
		if(n == 0)
			return 1;
		if(n < 0)
			return 0;
		if(m <= 0 && n >= 1)
			return 0;
		return coinChange(s, m-1, n)+coinChange(s, m, n-s[m-1]);
	}
	
	public static int dp(int s[],int m,int n){
		
		int val[] = new int[n+1];
		val[0] = 1;
		
		for(int i = 0;i < m;++i){
			for(int j = s[i];j <= n;++j){
				val[j] += val[j-s[i]];
			}
		}
		
		return val[n];
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3};
		int n = 4;
		
		System.out.println(coinChange(arr, arr.length, n));
		System.out.println(dp(arr, arr.length, n));
	}

}
