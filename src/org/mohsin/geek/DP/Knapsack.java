package org.mohsin.geek.DP;

public class Knapsack {

	public static int knapSack(int W,int w[],int val[],int n){
		if(W == 0 || n == 0)
			return 0;
		
		if(w[n-1] > W)
			return knapSack(W, w, val, n-1);
		return Integer.max(knapSack(W, w, val, n-1), knapSack(W-w[n-1], w, val, n-1)+val[n-1]);
	}
	
	public static int dp(int W,int Wt[],int val[],int n){
		
		int table[][] = new int[n+1][W+1];
		
		for(int i = 0;i <= n;++i){
			for(int w = 0;w <= W;++w){
				if(i == 0 || w == 0)
					table[i][w] = 0;
				else if(Wt[i-1] > w)
					table[i][w] = table[i-1][w];
				else
					table[i][w] = Integer.max(val[i-1]+table[i-1][w-Wt[i-1]], table[i-1][w]);
			}
		}
		return table[n][W];
	}
	
	public static void main(String[] args) {
		
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    
	    System.out.println(knapSack(W, wt, val, val.length));
	    System.out.println(dp(W, wt, val, val.length));

	}

}
