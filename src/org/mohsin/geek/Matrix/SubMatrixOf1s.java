package org.mohsin.geek.Matrix;

public class SubMatrixOf1s {

	public static void subMatrix(int mat[][]){
		
		int s[][] = new int[mat.length][mat[0].length];
		
		for(int i = 0;i < mat.length;++i)
			s[i][0] = mat[i][0];
		
		for(int i = 0;i < mat[0].length;++i)
			s[0][i] = mat[0][i];
		
		for(int i = 1;i < mat.length;++i){
			for(int j = 1;j < mat[0].length;++j){
				if(mat[i][j] == 1){
					s[i][j] = Math.min(s[i][j-1], Math.min(s[i-1][j], s[i-1][j-1]))+1;
				}else{
					s[i][j] = 0;
				}
			}
		}
		
		int max = 0;
		int x = 0,y = 0;
		for(int i = 0;i < mat.length;++i){
			for(int j = 0;j < mat[0].length;++j){
				if(s[i][j] > max){
					max = s[i][j];
					x = i;
					y = j;
				}
			}
		}
		
		for(int i = x;i > x-max;--i){
			for(int j = y;j > y-max;--j){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int M[][] =  {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		
		subMatrix(M);

	}

}
