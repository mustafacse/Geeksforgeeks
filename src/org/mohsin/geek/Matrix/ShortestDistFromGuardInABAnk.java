package org.mohsin.geek.Matrix;

import java.util.LinkedList;
import java.util.Queue;

class BankPoint{
	int x,y;
	int dist;
	
	public BankPoint(int i,int j){
		x = i;
		y = j;
		dist = 0;
	}

	public BankPoint(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}


public class ShortestDistFromGuardInABAnk {

	private static int rowNum[] = {0,-1,0,1};
	private static int colNum[] = {-1,0,1,0};
	
	
	public static boolean isValid(char mat[][],int i,int j){
		
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
			return false;
		return true;
	}
	
	public static boolean isSafe(char mat[][],int output[][],int i,int j){
		
		if(mat[i][j] != 'O' || output[i][j] != -1)
			return false;
		
		return true;
	}
	
	public static void printMatrix(int output[][]){
		
		for(int i = 0;i < output.length;++i){
			for(int j = 0;j < output[0].length;++j){
				System.out.print(output[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void shortestDist(char mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int output[][] = new int[row][col];
		
		Queue<BankPoint> q = new LinkedList<>();
		
		for(int i = 0;i < row;++i){
			for(int j = 0;j < col;++j){
				output[i][j] = -1;
				if(mat[i][j] == 'G'){
					output[i][j] = 0;
					q.add(new BankPoint(i, j));
				}
			}
		}
		
		while(!q.isEmpty()){
			
			BankPoint root = q.remove();
			int i = root.x;
			int j = root.y;
			
			int dist = root.dist;
			for(int k = 0;k < 4;++k){
				if(isValid(mat, i+rowNum[k], j+colNum[k]) && isSafe(mat, output, i+rowNum[k], j+colNum[k])){
					output[i+rowNum[k]][j+colNum[k]] = dist+1;
					q.add(new BankPoint(i+rowNum[k], j+colNum[k], dist+1));
				}
			}
		}
		
		printMatrix(output);
	}
	public static void main(String[] args) {
		
		char mat[][] =
		    {
		        {'O', 'O', 'O', 'O', 'G'},
		        {'O', 'W', 'W', 'O', 'O'},
		        {'O', 'O', 'O', 'W', 'O'},
		        {'G', 'W', 'W', 'W', 'O'},
		        {'O', 'O', 'O', 'O', 'G'}
		    };
		 
		shortestDist(mat);
	}

}
