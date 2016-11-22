package org.mohsin.geek.Matrix;

public class TurnImageBy90 {

	public static void turn(int mat[][]){
		
		int dest[][] = new int[mat[0].length][mat.length];
		
		for(int i = 0;i < mat.length;++i){
			for(int j = 0;j < mat[0].length;++j){
				dest[j][mat.length-1-i] = mat[i][j];
			}
		}
		
		for(int i = 0;i < dest.length;++i){
			for(int j = 0;j < dest[0].length;++j){
				System.out.print(dest[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		 int image[][] = {{1,2,3,4}, 
                 {5,6,7,8},
              {9,10,11,12}};
		 
		 turn(image);
	}

}
