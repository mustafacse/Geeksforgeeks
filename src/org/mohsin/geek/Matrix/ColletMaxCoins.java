package org.mohsin.geek.Matrix;

public class ColletMaxCoins {

	public static int collectCoins(char mat[][],int i,int j,int dir){
		
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == '#')
			return 0;
		
		int result = mat[i][j] == 'C' ? 1 : 0;
		
		if(dir == 1)
			return result + Math.max(collectCoins(mat, i, j+1, 1),collectCoins(mat, i+1, j, 0));
		
		return result + Math.max(collectCoins(mat, i, j-1, 0),collectCoins(mat, i+1, j, 1));
	}
	
	public static int dp(char mat[][],int res[][][],int i,int j,int dir){
		
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == '#')
			return 0;
		
		if(res[i][j][dir] != -1)
			return res[i][j][dir];
		
		int result = mat[i][j] == 'C' ? 1 : 0;
		if(dir == 1)
			res[i][j][dir] = result + Math.max(dp(mat, res, i, j+1, 1), dp(mat, res, i+1, j, 0));
		else
			res[i][j][dir] = result + Math.max(dp(mat, res, i, j-1, 0), dp(mat, res, i+1, j, 1));
		
		return res[i][j][dir];
	}
	
	public static void main(String[] args) {
		
		 char arr[][] = { {'E', 'C', 'C', 'C', 'C'},
                 {'C', '#', 'C', '#', 'E'},
                 {'#', 'C', 'C', '#', 'C'},
                 {'C', 'E', 'E', 'C', 'E'},
                 {'C', 'E', '#', 'C', 'E'}
               };

		 int res[][][] = new int[arr.length][arr[0].length][2];
		 
		 for(int i = 0;i < arr.length;++i){
			 for(int j = 0;j < arr[0].length;++j){
				 for(int k = 0;k < 2;++k)
					 res[i][j][k] = -1;
			 }
		 }
		 
		 System.out.println(dp(arr, res, 0, 0, 1));
 		 System.out.println(collectCoins(arr, 0, 0, 1));
	}

}
