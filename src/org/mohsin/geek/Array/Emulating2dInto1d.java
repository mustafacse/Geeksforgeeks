package org.mohsin.geek.Array;

public class Emulating2dInto1d {

	public static int[] emaulating(int mat[][])
	{
		int n = mat.length*mat[0].length;
		
		int arr[] = new int[n];
		
		for(int i = 0;i < mat.length;++i){
			for(int j = 0;j < mat[0].length;++j){
				arr[i*mat[0].length+j] = mat[i][j];
			}
		}
		
		return arr;
	}
	
	public static void print(int arr[],int n,int m){
		
		for(int i = 0;i < n;++i){
			for(int j = 0;j < m;++j)
			{
				System.out.print(arr[i*m+j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		int grid[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
		
		int arr[] = emaulating(grid);
		print(arr, grid.length, grid[0].length);

	}

}
