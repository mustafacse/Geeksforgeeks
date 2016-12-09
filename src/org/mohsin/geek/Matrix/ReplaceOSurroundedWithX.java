package org.mohsin.geek.Matrix;

public class ReplaceOSurroundedWithX {

	public static void floodFill(char mat[][],int x,int y,char prevC,char newC){
		
		if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length)
			return;
		
		if(mat[x][y] != prevC)
			return;
		
		mat[x][y] = newC;
		
		floodFill(mat, x+1, y, prevC, newC);
		floodFill(mat, x-1, y, prevC, newC);
		floodFill(mat, x, y+1, prevC, newC);
		floodFill(mat, x, y-1, prevC, newC);
	}
	
	public static void change(char mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j){
				if(mat[i][j] == 'O')
					mat[i][j] = '-';
			}
		}
		
		for(int i = 0;i < col;++i)
			floodFill(mat, 0, i, '-', 'O');
		for(int i = 0;i < col;++i)
			floodFill(mat, row-1, i, '-', 'O');
		for(int i = 0;i < row;++i)
			floodFill(mat, i, 0, '-', 'O');
		for(int i = 0;i < row;++i)
			floodFill(mat, i, col-1, '-', 'O');
		
		for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j){
				if(mat[i][j] == '-')
					mat[i][j] = 'X';
			}
		}
		
	}
	
	public static void printMatrix(char mat[][]) {

		for (int i = 0; i < mat.length; ++i) {
			for (int j = 0; j < mat[0].length; ++j)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		
		 char mat[][] =  {{'X', 'O', 'X', 'O', 'X', 'X'},
                 {'X', 'O', 'X', 'X', 'O', 'X'},
                 {'X', 'X', 'X', 'O', 'X', 'X'},
                 {'O', 'X', 'X', 'X', 'X', 'X'},
                 {'X', 'X', 'X', 'O', 'X', 'O'},
                 {'O', 'O', 'X', 'O', 'O', 'O'},
                };
		 
		 change(mat);
		 printMatrix(mat);

	}

}
