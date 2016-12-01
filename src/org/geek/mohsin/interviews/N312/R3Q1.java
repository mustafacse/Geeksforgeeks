package org.geek.mohsin.interviews.N312;

public class R3Q1 {

	public static int maxChain(int a[],int b[]){
		
		int n = a.length;
		int m = b.length;
		
		int dp[][] = new int[n+1][m+1];
		
		for(int i = 0;i <= n;++i){
			for(int j = 0;j <= m;++j){
				if(i == 0 || j == 0)
					dp[i][j] = 0;
				else if(a[i-1] == b[j-1])
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[n][m];
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 2,7,4,8,9,10};
		int b[] = {1,2,8,9,4};
		
		System.out.println(maxChain(a, b));
	}

}
