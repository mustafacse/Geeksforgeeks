package org.mohsin.geek.Matrix;

public class MinimumPointsToReachDestination {

	public static int minCost(int mat[][]){
		
		int m = mat.length;
		int n = mat[0].length;
		
		int dp[][] = new int[m][n];
		dp[m-1][n-1] = mat[m-1][n-1] > 0 ? 1 : Math.abs(mat[m-1][n-1])+1;
		
		for(int i = n-2;i >= 0;--i)
			dp[m-1][i] = Math.max(dp[m-1][i+1]-mat[m-1][i], 1);
		
		for(int i = m-2;i >= 0;--i)
			dp[i][n-1] = Math.max(dp[i+1][n-1]-mat[i][n-1], 1);
		
		for(int i = m-2;i >= 0;--i){
			for(int j = n-2;j >= 0;--j){
				int minExitPoints = Math.min(dp[i+1][j], dp[i][j+1]);
				dp[i][j] = Math.max(minExitPoints-mat[i][j], 1);
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		
		int points[][] = { {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
              };
		
		System.out.println(minCost(points));

	}

}
