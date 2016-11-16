package org.geek.mohsin.interviews.N309;

public class F1Q1 {

	private static int size = 0;
	private static int rowNum[] = {-1,-1,-1,0,0,1,1,1};
	private static int colNum[] = {-1,0,1,-1,1,-1,0,1};
	
	public static void biggestIsland(int arr[][]){
		
		boolean visited[][] = new boolean[arr.length][arr.length];
		int maxSize = 0;
		int count = 0;
		for(int row = 0;row < arr.length;++row){
			for(int col = 0;col < arr.length;++col){
				if(arr[row][col] == 1 && !visited[row][col]){
					size = 0;
					DFS(arr,row,col,visited);
					if(size > maxSize)
						maxSize = size;
					++count;
				}
			}
		}
		System.out.println("Maximum size island is "+maxSize);
		System.out.println("No of islands : "+count);
	}
	
	public static void DFS(int arr[][],int row,int col,boolean visited[][]){
		++size;
		visited[row][col] = true;
		for(int i = 0;i < 8;++i){
				if(isSafe(arr,row+rowNum[i],col+colNum[i],visited)){
					DFS(arr,row+rowNum[i],col+colNum[i],visited);
				}
		}
	}
	
	public static boolean isSafe(int arr[][],int row,int col,boolean visited[][]){
		if(row >= 0 && row < visited.length && col >= 0 && col < visited.length && !visited[row][col] && arr[row][col] == 1)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		int M[][]= {  {1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		    };

		biggestIsland(M);
	}

}
