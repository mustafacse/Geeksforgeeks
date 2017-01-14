package org.mohsin.geek.DP;

public class CountNoOFWays {

	public static int countWays(int n,int m){
		
		if(n <= 1)
			return n;
		
		int res = 0;
		for(int i = 1;i <= n && i <= m;++i)
			res += countWays(n-i, m);
		
		return res;
	}
	
	public static int dp(int n,int m){
		
		int ways[] = new int[n+1];
		
		ways[0] = 0;
		ways[1] = 1;
		
		for(int i = 1;i <= n;++i){
			for(int j = 1;j <= m && j <= i;++j){
				ways[i] += ways[i-j];
			}
		}
		
		return ways[n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
		int m = 2;
		
		System.out.println(countWays(n+1, m));
		System.out.println(dp(n+1, m));
	}

}
