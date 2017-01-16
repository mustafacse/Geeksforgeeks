package org.mohsin.geek.DP;

public class NoOfWaysToReachAScore {

	public static int dp(int n){
		
		int table[] = new int[n+1];
		
		table[0] = 1;
		
		for(int i = 3;i <= n;++i)
			table[i] += table[i-3];
		
		for(int i = 5;i <= n;++i)
			table[i] += table[i-5];
		
		for(int i = 10;i <= n;++i)
			table[i] += table[i-10];
		
		return table[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		System.out.println(dp(n));
	}

}
