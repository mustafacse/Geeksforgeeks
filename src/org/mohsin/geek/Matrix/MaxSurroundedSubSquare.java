package org.mohsin.geek.Matrix;

public class MaxSurroundedSubSquare {

	public static int subSquare(char mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int hor[][] = new int[row][col];
		int ver[][] = new int[row][col];
		
		hor[0][0] = ver[0][0] = (mat[0][0] == 'X' ? 1 : 0);
		
		for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j){
				if(mat[i][j] == 'O'){
					hor[i][j] = 0;
					ver[i][j] = 0;
				}else{
					hor[i][j] = j == 0 ? 1 : hor[i][j-1]+1;
					ver[i][j] = i == 0 ? 1 : ver[i-1][j]+1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = row-1;i >= 1;--i){
			for(int j = col-1;j >= 1;--j){
				
				int small = Math.min(hor[i][j], ver[i][j]);
				
				while(small > max){
					if(hor[i-small+1][j] >= small && ver[i][j-small+1] >= small){
						max = small;
					}
					small -= 1;
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		char mat[][] =  {{'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'},
               };

		System.out.println(subSquare(mat));
	}

}
