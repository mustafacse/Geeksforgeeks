package org.mohsin.geek.Matrix;

public class CreateAMatrixWithAltOandX {

	public static void createMatrix(int m,int n){
		
		int row = m;
		int col = n;
		
		char mat[][] = new char[m][n];
		
		int k = 0,l = 0;
		char ch = 'X';
		
		while(k < m && l < n){
			
			for(int i = l;i < n;++i)
				mat[k][i] = ch;
			++k;
			
			for(int i = k;i < m;++i)
				mat[i][n-1] = ch;
			--n;
			
			if(k < m){
				for(int i = n-1;i >= l;--i)
					mat[m-1][i] = ch;
				--m;
			}
			
			if(l < n){
				for(int i = m-1;i >= k;--i)
					mat[i][l] = ch;
				++l;
			}
			
			ch = ch == 'X' ? 'O' : 'X';
		}
		
		for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		createMatrix(6, 7);

	}

}
