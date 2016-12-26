package org.mohsin.geek.Matrix;

public class MaxDiffRows {

	public static int diff(int mat[][]){
		
		int rowSum[] = new int[mat.length];
		
		int sum = 0;
		for(int i = 0;i < mat.length;++i){
			sum = 0;
			for(int j = 0;j < mat[0].length;++j){
				sum += mat[i][j];
			}
			rowSum[i] = sum;
		}
		
		int maxDiff = rowSum[1]-rowSum[0];
		int minElement = rowSum[0];
		
		for(int i = 1;i < mat.length;++i){
			if(maxDiff < rowSum[i]-minElement)
				maxDiff = rowSum[i]-minElement;
			if(minElement > rowSum[i])
				minElement = rowSum[i];
		}
		
		return maxDiff;
	}
	public static void main(String[] args) {
		
		 int mat[][] = {{-1, 2, 3, 4},
                 {5, 3, -2, 1},
                 {6, 7, 2, -3},
                 {2, 9, 1, 4},
                 {2, 1, -2, 0}};

		 System.out.println(diff(mat));
	}

}
