package org.mohsin.geek.Matrix;

public class CountNoOfZeroes {

	public static int noOfZeroes(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int count = 0;
		
		int i = 0;
		int j = col-1;
		
		while(i < row && j >= 0){
			
			if(mat[i][j] == 1){
				--j;
			}else{
				count += (j+1);
				++i;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int mat[][] =
		    {
		        { 0, 0, 0, 0, 1 },
		        { 0, 0, 0, 1, 1 },
		        { 0, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1 }
		    };

		System.out.println(noOfZeroes(mat));
	}

}
