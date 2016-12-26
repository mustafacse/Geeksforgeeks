package org.mohsin.geek.Matrix;

public class MaximumDecimal {

	public static int maxDecimal(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int dp[][] = new int[row][col];
		
		if(mat[0][0] == 1)
			dp[0][0] = 1;
		
		for(int i = 1;i < col;++i){
			if(mat[0][i] == 1)
				dp[0][i] = (int) (dp[0][i-1]+Math.pow(2, i));
			else
				dp[0][i] = dp[0][i-1];
		}
		
		for(int i = 1;i < row;++i){
			if(mat[i][0] == 1)
				dp[i][0] = (int) (dp[0][i-1]+Math.pow(2, i));
			else
				dp[i][0] = dp[i-1][0];
		}
		
		for(int i = 1;i < row;++i){
			for(int j = 1;j < col;++j){
				if(mat[i][j] == 1)
					dp[i][j] = (int) (Math.max(dp[i-1][j], dp[i][j-1])+Math.pow(2, i+j));
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[row-1][col-1];
	}
	
	public static void main(String[] args) {
		
		 int mat[][] = {{ 1 ,1 ,0 ,1 },
			        { 0 ,1 ,1 ,0 },
			        { 1 ,0 ,0 ,1 },
			        { 1 ,0 ,1 ,1 },
			    };

		 System.out.println(maxDecimal(mat));
	}

}
