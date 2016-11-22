package org.mohsin.geek.Matrix;

public class BooleanMatrix {

	public static void print(int mat[][]){
		
		boolean rowFlag = false;
		boolean colFlag = false;
		
		for(int i = 0;i < mat.length;++i){
			if(mat[i][0] == 1){
				colFlag = true;
				break;
			}
		}
		
		for(int i = 0;i < mat[0].length;++i){
			if(mat[0][i] == 1){
				rowFlag = true;
				break;
			}
		}
		
		for(int i = 1;i < mat.length;++i){
			for(int j = 1;j < mat[0].length;++j){
				if(mat[i][j] == 1){
					mat[i][0] = 1;
					mat[0][j] = 1;
				}
			}
		}
		
		for(int i = 1;i < mat.length;++i){
			for(int j = 1;j < mat[0].length;++j){
				if(mat[i][0] == 1 || mat[0][j] == 1){
					mat[i][j] = 1;
				}
			}
		}
		
		if(rowFlag){
			for(int i = 0;i < mat[0].length;++i)
				mat[0][i] = 1;
		}
		
		if(colFlag){
			for(int i = 0;i < mat.length;++i)
				mat[i][0] = 1;
		}
		
		for(int i = 0;i < mat.length;++i){
			for(int j = 0;j < mat[0].length;++j){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int mat[][] = { {1, 0, 0, 1},
			        {0, 0, 1, 0},
			        {0, 0, 0, 0},
		    };
		
		print(mat);
	}

}
