package org.mohsin.geek.Matrix;

import java.util.Arrays;

public class CommonElementInSortedMatrix {

	public static int common(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int column[] = new int[col];
		Arrays.fill(column, col-1);
		
		int minRow = 0;
		while(column[minRow] >= 0){
			
			for(int i = 0;i < row;++i){
				if(mat[i][column[i]] < mat[minRow][column[minRow]])
					minRow = i;
			}
			
			int count = 0;
			for(int i = 0;i < row;++i){
				if(mat[i][column[i]] > mat[minRow][column[minRow]])
				{
					if(column[i] == 0)
						return -1;
					column[i] -= 1;
				}else{
					++count;
				}
			}
			if(count == row)
				return mat[minRow][column[minRow]];
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		int mat[][] = { {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9},
              };

		System.out.println(common(mat));
	}

}
