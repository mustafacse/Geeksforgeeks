package org.mohsin.geek.Matrix;

public class MaximumDecimalValue {

	public static int recursive(int mat[][],int i,int j,int m,int n){
		
		if(i >=  m || j >= n) return 0;
		
		int res = Integer.max(recursive(mat, i+1, j, m, n), recursive(mat, i, j+1, m, n));
		
		if(mat[i][j] == 1)
			return res+(int)Math.pow(2, i+j);
		return res;
	}
	
	public static int optimizedDP(int mat[][],int m,int n){
		
		int dp[][] = new int[m][n];
		
		dp[0][0] = mat[0][0];
		
		for(int i = 1;i < n;++i){
			if(mat[0][i] == 1)
				dp[0][i] = dp[0][i-1]+(int)Math.pow(2, i);
			else
				dp[0][i] = dp[0][i-1];
		}
		
		for(int i = 1;i < m;++i)
		{
			if(mat[i][0] == 0)
				dp[i][0] = dp[i-1][0]+(int)Math.pow(2, i);
			else
				dp[i][0] = dp[i-1][0];
		}
		
		for(int i = 1;i < m;++i){
			for(int j = 1;j < n;++j){
				if(mat[i][j] == 1)
					dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1])+(int)Math.pow(2, i+j);
				else
					dp[i][j] = Integer.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		return dp[m-1][n-1];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = {{1, 1, 0, 1},
                 {0, 1, 1, 0},
                 {1, 0, 0, 1},
                 {1, 0, 1, 1}};
		
		System.out.println(recursive(mat, 0, 0, mat.length, mat[0].length));
		System.out.println(optimizedDP(mat, mat.length, mat[0].length));
	}

}
