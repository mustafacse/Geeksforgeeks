package org.mohsin.geek.Matrix;

public class KthRowAndColumnINBooleanMatrix {

	public static int kth(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int i = 0;
		int j = col-1;
		
		int res = -1;
		
		while(i < row && j >= 0){
			
			if(mat[i][j] == 0){
				while(j >= 0 && mat[i][j] == 0)
					--j;
				
				if(j == -1)
				{
					res = i;
					break;
				}
				++i;
			}
			else{
				
				while(i < row && mat[i][j] == 1)
					++i;
				
				if(i == row)
				{
					res= j;
					break;
				}else{
					--j;
				}
			}
		}
		
		if(res == -1)
			return res;
		
		for(i = 0;i < row;++i)
			if(res != i && mat[i][res] != 1)
				return -1;
		
		for(i = 0;i < col;++i)
			if(res != i && mat[res][i] != 0)
				return -1;
		
		return res;
	}
	
	
	public static void main(String[] args) {
		
		int mat[][] = {{0, 0, 1, 1, 0},
                 {0, 0, 0, 1, 0},
                 {1, 1, 1, 1, 0},
                 {0, 0, 0, 0, 0},
                 {1, 1, 1, 1, 1}};
		
		System.out.println(kth(mat));
	}

}
