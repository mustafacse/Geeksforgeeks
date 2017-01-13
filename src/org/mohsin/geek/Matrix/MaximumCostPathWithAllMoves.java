package org.mohsin.geek.Matrix;

import java.util.HashSet;
import java.util.Set;

class Cell{
	int x,y,dist;
	
	public Cell(int i,int j,int x){
		x = i;
		y = j;
		dist = x;
	}
}


public class MaximumCostPathWithAllMoves {

	/*private static int rowNum[] = {0,-1,0,1};
	private static int colNum[] = {-1,0,1,0};*/
	
	public static int maxCost(int grid[][]){
		
		int row = grid.length;
		int col = grid[0].length;
		
		int dist[][] = new int[row][col];
		
		for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j){
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Set<Cell> s = new HashSet<>();
		s.add(new Cell(0,0,0));
		
		dist[0][0] = grid[0][0];
		
		while(!s.isEmpty()){
			
			
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
