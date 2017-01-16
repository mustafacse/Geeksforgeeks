package org.mohsin.geek.DP;

public class MaximumSumInTwoTraversals {

	public static boolean isValid(int x,int y,int m,int n){
		if(x < 0 || x >= m || y < 0 || y >= n)
			return false;
		return true;
	}
	
	public static int dp(int cost[][],int table[][][],int x,int y1,int y2){
		
		if(!isValid(x, y1, cost.length, cost[0].length) || !isValid(x, y2, cost.length, cost[0].length))
			return Integer.MIN_VALUE;
		
		if(x == cost.length-1 && y1 == 0 && y2 == cost[0].length-1)
			return cost[x][y1]+cost[x][y2];
		
		if(table[x][y1][y2] != -1)
			return table[x][y1][y2];
		
		int temp = y1 == y2 ? cost[x][y1] : cost[x][y1] + cost[x][y2];
		
		int ans = Integer.MIN_VALUE;
		
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1+1, y2+1));
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1+1, y2-1));
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1+1, y2));
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1-1, y2+1));
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1-1, y2-1));
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1-1, y2));
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1, y2+1));
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1, y2-1));
		ans = Integer.max(ans, temp+dp(cost, table, x+1, y1, y2));
		
		return table[x][y1][y2] = ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[][] = {{3, 6, 8, 2},
                 {5, 2, 4, 3},
                 {1, 1, 20, 10},
                 {1, 1, 20, 10},
                 {1, 1, 20, 10},
                };
		 
		 int table[][][] = new int[arr.length][arr[0].length][arr[0].length];
		 
		 for(int i = 0;i < arr.length;++i){
			 for(int j = 0;j < arr[0].length;++j){
				 for(int k = 0;k < arr[0].length;++k)
					 table[i][j][k] = -1;
			 }
		 }
		 
		 System.out.println(dp(arr, table, 0, 0, arr[0].length-1));
	}

}
