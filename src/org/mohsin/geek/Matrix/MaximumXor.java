package org.mohsin.geek.Matrix;

public class MaximumXor {

	public static int maxXor(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int max = 0;
		int rXor = 0;
		int cXor = 0;
		
		for(int i = 0;i < row;++i){
			rXor = 0;
			cXor = 0;
			for(int j = 0;j < col;++j){
				rXor ^= mat[i][j];
				cXor ^= mat[j][i];
			}
			
			max = Math.max(rXor, cXor);
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {
		
		int mat[][] = {{1 , 5, 4},
		        {3 , 7, 2 },
		        {5 , 9, 10}
		    };
		
		System.out.println(maxXor(mat));

	}

}
