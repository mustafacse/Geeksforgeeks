package org.mohsin.geek.Matrix;

public class ShortestSafeRoute {

	private static int rowNum[] = {0,-1,0,1};
	private static int colNum[] = {-1,0,1,0};
	private static int minDist = Integer.MAX_VALUE;
	
	public static boolean isValid(int mat[][],boolean visited[][],int i,int j){
		if(mat[i][j] == 0 || visited[i][j])
			return false;
		return true;
	}
	
	public static boolean isSafe(int mat[][],int i,int j){
		if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
			return false;
		return true;
	}
	
	public static void markUnSafe(int mat[][]){
		
		for(int i = 0;i < mat.length;++i){
			for(int j = 0;j < mat[0].length;++j){
				if(mat[i][j] == 0){
					for(int k = 0;k < 4;++k){
						if(isSafe(mat,i+rowNum[k],j+colNum[k]))
							mat[i+rowNum[k]][j+colNum[k]] = -1;
					}
				}
			}
		}
		
		for(int i = 0;i < mat.length;++i){
			for(int j = 0;j < mat[0].length;++j)
				if(mat[i][j] == -1)
					mat[i][j] = 0;
		}
	}
	
	public static void shortestDist(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		boolean visited[][] = new boolean[row][col];
		
		markUnSafe(mat);
		
		for(int i = 0;i < row;++i){
			
			for(int j = 0;j < row;++j){
				for(int k = 0;k < col;++k)
					visited[j][k] = false;
			}
			
			if(mat[i][0] == 1){
				shortestDistUtil(mat,visited,i,0,col,0);
				if(minDist == col-1)
					break;
			}
		}
		
		System.out.println(minDist);
	}
	
	public static void shortestDistUtil(int mat[][],boolean visited[][],int i,int j,int col,int dist){
		
		if(j == col-1){
			minDist = Math.min(dist, minDist);
			return;
		}
		
		if(dist > minDist)
			return;
		
		visited[i][j] = true;
		
		for(int k = 0;k < 4;++k){
			if(isSafe(mat, i+rowNum[k], j+colNum[k]) && isValid(mat, visited, i+rowNum[k], j+colNum[k]))
				shortestDistUtil(mat, visited, i+rowNum[k], j+colNum[k], col, dist+1);
		}
		
		visited[i][j] = false;
	}
	
	public static void main(String[] args) {
		
		int mat[][] =
		    {
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
		    };

		shortestDist(mat);
	}

}
