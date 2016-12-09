package org.mohsin.geek.Matrix;

public class CollectMaxPointsWithTwoTraversals {

	public static boolean isValid(int mat[][],int x,int y1,int y2){
		
		if(x < 0 || x >= mat.length || y1 < 0 || y1 >= mat[0].length || y2 < 0 || y2 >= mat[0].length)
			return false;
		return true;
	}
	
	public static int collect(int mat[][],int x,int y1,int y2){
		
		if(!isValid(mat,x,y1,y2) )
			return Integer.MIN_VALUE;
		
		if(x == mat.length-1 && y1 == 0 && y2 == mat[0].length-1)
			return mat[x][y1]+mat[x][y2];
		
		int ans = y1 == y2 ? mat[x][y1] : mat[x][y1]+mat[x][y2];
		
		ans += Math.max(collect(mat,x+1,y1+1,y2),Math.max(collect(mat, x+1,y1+1,y2+1),Math.max(collect(mat,x+1,y1+1,y2-1),Math.max(collect(mat,x+1,y1-1,y2), Math.max(collect(mat,x+1,y1-1,y2+1), Math.max(collect(mat,x+1,y1-1,y2-1),
				Math.max(collect(mat,x+1,y1,y2), Math.max(collect(mat,x+1,y1,y2+1), collect(mat,x+1,y1,y2-1)))))))));
		return ans;
	}
	
	public static void main(String[] args) {
		
		 int arr[][] = {{3, 6, 8, 2},
                 {5, 2, 4, 3},
                 {1, 1, 20, 10},
                 {1, 1, 20, 10},
                 {1, 1, 20, 10},
                };
		 
		 System.out.println(collect(arr,0,0,arr[0].length-1));

	}

}
