package org.mohsin.geek.Matrix;

public class PrintAllPossiblePaths {

	public static void printPaths(int mat[][],int i,int j,int m,int n,int path[],int pos){
		
		if(i == m-1){
			for(int k = j;k < n;++k)
				path[pos+k-j] = mat[i][k];
			
			for(int l = 0;l < pos+n-j;++l)
				System.out.print(path[l]+" ");
			System.out.println();
			return;
		}
		
		if(j == n-1){
			for(int k = i;k < m;++k)
				path[pos+k-i] = mat[k][j];
			
			for(int l = 0;l < pos+m-i;++l)
				System.out.print(path[l]+" ");
			System.out.println();
			return;
		}
		
		path[pos] = mat[i][j];
		
		printPaths(mat, i+1, j, m, n, path, pos+1);
		printPaths(mat, i, j+1, m, n, path, pos+1);
		
	}
	
	public static void main(String[] args) {
		
		 int mat[][] = { {1, 2, 3}, {4, 5, 6} };
		 int path[] = new int[mat.length+mat[0].length];
		 printPaths(mat, 0, 0, mat.length, mat[0].length, path, 0);

	}

}
