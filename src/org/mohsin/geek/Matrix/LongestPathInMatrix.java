package org.mohsin.geek.Matrix;

import java.util.Arrays;

public class LongestPathInMatrix {

	public static int longestPath(int mat[][],int dp[][],int i,int j,int row,int col){
		
		if(i < 0 || i >= row || j < 0 || j >= col)
			return 0;
		
		if(dp[i][j] != -1)
			return dp[i][j];
		
		if(i+1 < row && mat[i][j]+1 == mat[i+1][j])
			return dp[i][j] = 1 + longestPath(mat, dp, i+1, j, row, col);
		if(i-1 >= 0 && mat[i][j]+1 == mat[i-1][j])
			return dp[i][j] = 1 + longestPath(mat, dp, i-1, j, row, col);
		if(j+1 < col && mat[i][j]+1 == mat[i][j+1])
			return dp[i][j] = 1 + longestPath(mat, dp, i, j+1, row, col);
		if(j-1 >= 0 && mat[i][j]+1 == mat[i][j-1])
			return dp[i][j] = 1 + longestPath(mat, dp, i, j-1, row, col);
		
		return dp[i][j] = 1;
	}
	
	public static void main(String[] args) {
		
		 int  mat[][] = {{1, 2, 9},
                 {5, 3, 8},
                 {4, 6, 7}};
		 
		 int row = mat.length;
		 int col = mat[0].length;
		 int dp[][] = new int[row][col];
		 for(int i = 0;i < row;++i)
			 Arrays.fill(dp[i], -1);
		 
		 int res = 0;
		 for(int i = 0;i < row;++i){
			 for(int j = 0;j < col;++j){
				 if(dp[i][j] == -1)
				 {
					 longestPath(mat, dp, i, j, row, col);
				 }
			 if(dp[i][j] > res)
				 res = dp[i][j];
			 }
		 }
		 
		 System.out.println(res);
	}

}
