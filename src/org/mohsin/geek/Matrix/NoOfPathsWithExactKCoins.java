package org.mohsin.geek.Matrix;

public class NoOfPathsWithExactKCoins {

	public static int noOfWays(int mat[][],int m,int n,int k){
		
		if(m < 0 || n < 0)
			return 0;
		if(m == 0 && n == 0 && k == mat[m][n])
			return 1;
		
		return noOfWays(mat, m-1, n, k-mat[m][n])+noOfWays(mat, m, n-1, k-mat[m][n]);
	}
	
	public static int dp(int mat[][],int mem[][][],int m,int n,int k){
		
		if(m < 0  || n < 0)
			return 0;
		if(m == 0 && n == 0 && k == mat[m][n])
			return 1;
		
		if(mem[m][n][k] != -1)
			return mem[m][n][k];
		
		mem[m][n][k] = dp(mat, mem, m-1, n, k-mat[m][n])+dp(mat, mem, m, n-1, k-mat[m][n]);
		return mem[m][n][k];
	} 
	
	public static void main(String[] args) {
		
		int k = 12;
	    int mat[][] = { {1, 2, 3},
	                      {4, 6, 5},
	                      {3, 2, 1}
	                  };
	    
	    int row = mat.length;
	    int col = mat[0].length;
	    
	    int mem[][][] = new int[row][col][k+1];
	    for(int i = 0;i < row;++i)
	    	for(int j = 0;j < col;++j)
	    		for(int m = 0;m <= k;++m)
	    			mem[i][j][m] = -1;
	    
	    			
	    System.out.println(noOfWays(mat, row-1, col-1, k));
	    System.out.println(dp(mat, mem, row-1, col-1, k));
	}

}
