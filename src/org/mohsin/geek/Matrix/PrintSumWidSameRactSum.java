package org.mohsin.geek.Matrix;

public class PrintSumWidSameRactSum {

	public static void dp(int mat[][]){
		
		int m = mat.length;
		int n = mat[0].length;
		
		int sum[][] = new int[m][n];
		int sumR[][] = new int[m][n];
		int total = 0;
		
		for(int i = 0;i < m;++i){
			for(int j = 0;j < n;++j){
				total += mat[i][j];
				sum[i][j] = sumR[i][j] = mat[i][j];
			}
		}
		
		for(int i = 1;i < m;++i){
			sum[i][0] += sum[i-1][0];
			sumR[m-i-1][n-1] += sumR[m-i][n-1];
		}
		
		for(int j = 1;j < n;++j){
			sum[0][j] += sum[0][j-1];
			sumR[m-1][n-j-1] += sumR[m-1][n-j];
		}
		
		
		for(int i = 1;i < m;++i){
			for(int j = 1;j < n;++j){
				sum[i][j] += (sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]);
				sumR[m-i-1][n-j-1] += (sumR[m-i][n-j-1]+sumR[m-i-1][n-j]-sumR[m-i][n-j]);
			}
		}
		
		for(int i = 0;i < m;++i){
			for(int j = 0;j < n;++j){
				int diaSum = sum[i][j]+sumR[i][j]-mat[i][j];
				if(2*diaSum == total)
					System.out.println(i+", "+j);
					
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int mat[][] =
			    {
			        {1, 2, 3, 5},
			        {4, 1, 0, 2},
			        {0, 1, 2, 0},
			        {7, 1, 1, 0}
			    };
		 
		 dp(mat);
	}

}
