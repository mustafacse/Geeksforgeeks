package org.mohsin.geek.DP;

import java.util.Arrays;

public class MinCostToTravelByTrain {

	private static int INF = Integer.MAX_VALUE;
	
	public static int minCost(int cost[][],int s,int d){
		
		if(s == d || s+1 == d)
			return cost[s][d];
		
		int res = cost[s][d];
		
		for(int i = s+1;i < d;++i){
			
			int temp = minCost(cost, s, i)+minCost(cost, i, d);
			if(temp < res)
				res = temp;
		}
		
		return res;
	}
	
	public static int dp(int cost[][]){
		
		int dist[] = new int[cost.length];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		for(int i = 0;i < cost.length;++i){
			for(int j = i+1;j < cost.length;++j){
				if(dist[j] > dist[i]+cost[i][j])
					dist[j] = dist[i]+cost[i][j];
			}
		}
		
		return dist[cost.length-1];
	}
	
	
	public static void main(String[] args) {
		
		 int cost[][] = { {0, 15, 80, 90},
                 {INF, 0, 40, 50},
                 {INF, INF, 0, 70},
                 {INF, INF, INF, 0}
               };
		 
		 System.out.println(minCost(cost, 0, cost.length-1));
		 System.out.println(dp(cost));

	}

}
