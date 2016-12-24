package org.mohsin.geek.Matrix;

public class MaxLengthSnakeSequence {

	public static void maxSequence(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int dp[][] = new int[row][col];
		
		int maxLen =Integer.MIN_VALUE;
		int maxRow = 0,maxCol = 0;
		
		for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j){
				
				if(i != 0 || j != 0){
					
					if(i > 0 && Math.abs(mat[i][j]-mat[i-1][j]) == 1){
						dp[i][j] = Math.max(dp[i][j], dp[i-1][j]+1);
						if(maxLen < dp[i][j]){
							maxLen = dp[i][j];
							maxRow = i;
							maxCol = j;
						}
					}
					
					if(j > 0 && Math.abs(mat[i][j] - mat[i][j-1]) == 1){
						dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+1);
						if(maxLen < dp[i][j]){
							maxLen = dp[i][j];
							maxRow = i;
							maxCol = j;
						}
					}
				}
			}
		}
		
		
		System.out.print(mat[maxRow][maxCol]+" ");
		while(dp[maxRow][maxCol] != 0){
			if(maxRow > 0 && dp[maxRow][maxCol] == dp[maxRow-1][maxCol]+1){
				System.out.print(mat[maxRow-1][maxCol]+" ");
				--maxRow;
			}else if(maxCol > 0 && dp[maxRow][maxCol] == dp[maxRow][maxCol-1]+1){
				System.out.print(mat[maxRow][maxCol-1]+" ");
				maxCol--;
			}
		}
	}
	public static void main(String[] args) {
		
		 int mat[][] =
			    {
			        {9, 6, 5, 2},
			        {8, 7, 6, 5},
			        {7, 3, 1, 6},
			        {1, 1, 1, 7},
			    };

		 maxSequence(mat);
	}

}
