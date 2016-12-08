package org.mohsin.geek.Matrix;

public class PrintMatixDiagonally {

	public static void print(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int c = 0;
		while(c < col){
			int i = 0;
			int j = c;
			while(j >= 0 && i < row){
				System.out.print(mat[i][j]+" ");
				++i;
				--j;
			}
			System.out.println();
			++c;
		}
		
		int r = 1;
		while(r < row){
			int i = r;
			int j = col-1;
			while(i < row && j >= 0){
				System.out.print(mat[i][j]+" ");
				++i;
				--j;
			}
			System.out.println();
			++r;
		}
	}
	
	public static void main(String[] args) {
		
		int mat[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
               };

		print(mat);
	}

}
