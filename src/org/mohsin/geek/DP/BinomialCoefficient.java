package org.mohsin.geek.DP;

public class BinomialCoefficient {

	public static int recur(int n,int k){
		if(k == 0 || k== n)
			return 1;
		return recur(n-1, k-1)+recur(n-1, k);
	}
	
	public static int dp(int n,int k){
		
		int table[][] = new int[n+1][k+1];
		
		for(int i = 0;i <= n;++i){
			for(int j = 0;j <= Integer.min(i, k);++j){
				if(j == 0 || i == j)
					table[i][j] = 1;
				else
					table[i][j] = table[i-1][j]+table[i-1][j-1];
			}
		}
		return table[n][k];
	}
	
	public static void main(String[] args) {
		
		int n = 5,k = 2;
		System.out.println(recur(n, k));
		System.out.println(dp(n, k));

	}

}
