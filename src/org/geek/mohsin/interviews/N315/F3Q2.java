package org.geek.mohsin.interviews.N315;

public class F3Q2 {

	public static int minCostPath(int arr[][]){
		
		int row = arr.length;
		int col = arr[0].length;
		
		int cost[][] = new int[row][col];
		cost[0][0] = arr[0][0];
		
		for(int i = 1;i < row;++i)
			cost[i][0] = cost[i-1][0]+arr[i][0];
		
		for(int i = 1;i < col;++i)
			cost[0][i] = cost[0][i-1]+arr[0][i];
		
		for(int i = 1;i < row;++i){
			for(int j = 1;j < col;++j){
				cost[i][j] = Math.min(cost[i-1][j-1], Math.min(cost[i-1][j], cost[i][j-1]))+arr[i][j];
			}
		}
		
		/*for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j){
				System.out.print(cost[i][j]+" ");
				
			}
			System.out.println();
		}*/
		
		return cost[row-1][col-1];
		
	}
	
	public static void main(String[] args) {
	
		int ar[][] = { {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} };
		
		System.out.println(minCostPath(ar));
	}

}
