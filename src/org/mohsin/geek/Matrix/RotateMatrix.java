package org.mohsin.geek.Matrix;

public class RotateMatrix {

	public static void rotate(int mat[][]){
		
		int m = mat.length;
		int n = mat[0].length;
		
		int k = 0,l = 0;
		while(k < m && l < n){
			if(k+1 >= m || l+1 >= n)
				break;
			int prev = mat[k+1][l];
			for(int i = l;i < n;++i)
			{
				int curr = mat[k][i];
				mat[k][i] = prev;
				prev = curr;
			}
			++k;
			
			for(int i = k;i < m;++i){
				int curr = mat[i][n-1];
				mat[i][n-1] = prev;
				prev = curr;
			}
			
			--n;
			
			if(k < m){
				for(int i = n-1;i >= l;--i)
				{
					int curr = mat[m-1][i];
					mat[m-1][i] = prev;
					prev = curr;
				}
				--m;
			}
			
			if(l < n){
				for(int i = m-1;i >= k;--i)
				{
					int curr = mat[i][l];
					mat[i][l] = prev;
					prev = curr;
				}
				++l;
			}
		}
	}
	
	public static void printMatrix(int mat[][]){
		
		for(int i = 0;i < mat.length;++i){
			for(int j = 0;j < mat[0].length;++j){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		 int mat[][] = { {1,  2,  3,  4},
			        {5,  6,  7,  8},
			        {9,  10, 11, 12},
			        {13, 14, 15, 16}  };
			 

		 rotate(mat);
		 printMatrix(mat);
	}

}
