package org.mohsin.geek.Graph;

public class NoOfIslands {

	private static int nextR[] = {-1,-1,-1,0,0,1,1,1};
	private static int nextC[] = {-1,0,1,-1,1,-1,0,1};
	
	public static boolean isSafe(int graph[][],boolean visited[][],int row,int col){
		
		if(row >= 0 && row < graph.length && col >= 0 && col < graph.length && graph[row][col] == 1
				&& !visited[row][col])
			return true;
		return false;
			
	}
	
	public static void DFS(int graph[][],boolean visited[][],int row,int col){
		visited[row][col] = true;
		for(int k = 0;k < 8;++k){
			if(isSafe(graph, visited, row+nextR[k], col+nextC[k]))
				DFS(graph, visited, row+nextR[k], col+nextC[k]);
		}
	}
	
	public static int countIslands(int graph[][]){
		
		int row = graph.length;
		int col = row;
		
		boolean visited[][] = new boolean[row][col];
		int count = 0;
		
		for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j){
				if(!visited[i][j] && graph[i][j] == 1){
					DFS(graph, visited, i, j);
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		int M[][]= {  {1, 1, 0, 0, 0},
		        {0, 1, 0, 0, 1},
		        {1, 0, 0, 1, 1},
		        {0, 0, 0, 0, 0},
		        {1, 0, 1, 0, 1}
		    };

		System.out.println(countIslands(M));
	}

}
