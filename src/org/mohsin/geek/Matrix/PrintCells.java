package org.mohsin.geek.Matrix;

public class PrintCells {

	public static void cellPrint(int mat[][]){
		
		int m = mat.length;
		int n = mat[0].length;
		
		int sum[][] = new int[m][n];
		int remain[][] = new int[m][n];
		
		int totalSum = 0;
		for(int i = 0;i < m;++i){
			for(int j = 0;j < n;++j){
				sum[i][j] = remain[i][j] = mat[i][j];
				totalSum += mat[i][j];
			}
		}
		
		for(int i = 1;i < m;++i){
			sum[i][0] += sum[i-1][0];
			remain[m-i-1][n-1] += remain[m-i][n-1];
		}
		
		for(int j = 1;j < n;++j){
			sum[0][j] += sum[0][j-1];
			remain[m-1][n-j-1] += remain[m-1][n-j];
		}
		
		for(int i = 1;i < m;++i){
			for(int j = 1;j < n;++j){
				sum[i][j] += sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
				remain[m-i-1][n-j-1] += remain[m-i-1][n-j]+remain[m-i][n-j-1]-remain[m-i][n-j];
			}
		}
		
		for(int i = 0;i < m;++i){
			for(int j = 0;j < n;++j){
				int curr = sum[i][j]+remain[i][j]-mat[i][j];
				if(curr*2 == totalSum)
					System.out.println(i+", "+j);
			}
		}
	}
	
	public static void main(String[] args) {
		
		 int mat[][] =
			    {
			        {1, 2, 3, 5},
			        {4, 1, 0, 2},
			        {0, 1, 2, 0},
			        {7, 1, 1, 0}
			    };
		 
		 cellPrint(mat);
	}

}
