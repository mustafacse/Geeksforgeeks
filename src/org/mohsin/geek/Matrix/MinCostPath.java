package org.mohsin.geek.Matrix;

public class MinCostPath {

	public static int minCost(int mat[][]){
		
		int cost[][] = new int[mat.length][mat[0].length];
		
		cost[0][0] = mat[0][0];
		
		for(int i = 1;i < mat.length;++i){
			cost[i][0] = cost[i-1][0]+mat[i][0];
		}
		
		for(int i = 1;i < mat[0].length;++i){
			cost[0][i] = cost[0][i-1]+mat[0][i];
		}
		
		for(int i = 1;i < mat.length;++i){
			for(int j = 1;j < mat[0].length;++j){
				cost[i][j] = Math.min(cost[i][j-1], Math.min(cost[i-1][j], cost[i-1][j-1]))+mat[i][j];
			}
		}
		
		/*for(int i = 0;i < mat.length;++i){
			for(int j = 0;j < mat[0].length;++j){
				System.out.print(cost[i][j]+" ");
			}
			System.out.println();
		}*/
		
		return cost[mat.length-1][mat[0].length-1];
	}
	
	public static void main(String[] args) {
		 int mat[][] = { {1, 2, 3},
                 {4, 8, 2},
                 {1, 5, 3} };
		 
		 System.out.println(minCost(mat));

	}

}
