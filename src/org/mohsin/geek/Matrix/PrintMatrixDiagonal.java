package org.mohsin.geek.Matrix;

public class PrintMatrixDiagonal {

	public static void print(int mat[][]){
		
		int n = mat.length;
		
		int k = 0;
		int i = 0,j = 0;
		
		boolean isUp = true;
		
		for(;k < n*n;){
			
			if(isUp){
				for(;i >= 0  && j < n; ++j,--i){
					System.out.print(mat[i][j]+" ");
					++k;
				}
				
				if(i < 0 && j < n)
					i = 0;
				if(j == n){
					i += 2;j--;}
			}else{
				for(;j >= 0 && i < n;++i,--j){
					System.out.print(mat[i][j]+" ");
					++k;
				}
				if(j < 0 && i < n)
					j = 0;
				if(i == n){
					j +=2;i--;}
			}
			
			isUp = !isUp;
		}
	}
	
	public static void main(String[] args) {
		
		int mat[][] = {{1, 2, 3},
		        {4, 5, 6},
		        {7, 8, 9}
		    };
		print(mat);
	}

}
