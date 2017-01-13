package org.mohsin.geek.DP;

public class MinCostPath {

	public static int minCost(int cost[][],int m,int n){
		if(m == 0  && n == 0)
			return cost[m][n];
		if(m < 0 || n < 0)
			return Integer.MAX_VALUE;
		return cost[m][n]+Integer.min(minCost(cost, m-1, n-1), Integer.min(minCost(cost, m, n-1), 
				minCost(cost, m-1, n)));
	}
	
	public static int optimizedDPSol(int cost[][]){
		
		int m = cost.length;
		int n = cost[0].length;
		
		int dp[][] = new int[m][n];
		
		dp[0][0] = cost[0][0];
		
		for(int i = 1;i < m;++i)
			dp[i][0] = dp[i-1][0]+cost[i][0];
		
		for(int j = 1;j < n;++j)
			dp[0][j] = dp[0][j-1]+cost[0][j];
		
		for(int i = 1;i < m;++i){
			for(int j = 1;j < n;++j){
				dp[i][j] = Integer.min(dp[i-1][j], Integer.min(dp[i-1][j-1], dp[i][j-1]))+cost[i][j];
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		 int cost[][] = { {1, 2, 3},
                 {4, 8, 2},
                 {1, 5, 3} };
		 
		 System.out.println(minCost(cost, cost.length-1, cost[0].length-1));
		 System.out.println(optimizedDPSol(cost));

	}

}
