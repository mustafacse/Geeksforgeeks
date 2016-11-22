package org.mohsin.geek.Matrix;

public class SpiralMatrix {

	public static void spiralPrint(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int k = 0,l = 0;
		while(k < row && l < col){
			
			for(int i = l;i < col;++i)
				System.out.print(mat[k][i]+" ");
			++k;
			
			for(int i = k;i < row;++i)
				System.out.print(mat[i][col-1]+" ");
			
			--col;
			
			if(k < row){
				for(int i = col-1;i >= l;--i)
					System.out.print(mat[row-1][i]+" ");
				--row;
			}
			
			if(l < col){
				for(int i = row-1;i >= k;--i){
					System.out.print(mat[i][l]+" ");
				}
				++l;
			}
		}
	}
	public static void main(String[] args) {
		
		int a[][] = { {1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		    };

		spiralPrint(a);
	}

}
