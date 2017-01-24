package org.mohsin.geek.DP;

public class DPPractice {

	public static int palindromePartition(String str){
		
		int n = str.length();
		
		boolean dp[][] = new boolean[n][n];
		
		for(int i = 0;i < n;++i)
			dp[i][i] = true;
		
		for(int len = 2;len <= n;++len){
			for(int i = 0;i < n-len+1;++i){
				int j = i+len-1;
				
				if(str.charAt(i) == str.charAt(j) && len == 2)
					dp[i][j] = true;
				else if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1])
					dp[i][j] = true;
				else
					dp[i][j] = false;
			}
		}
		
		int c[] = new int[n];
		
		c[0] = 0;
		
		for(int i = 0;i < n;++i){
			if(dp[0][i] == true)
				c[i] = 0;
			else{
				c[i] = Integer.MAX_VALUE;
				for(int j = 0;j < i;++j){
					if(dp[j+1][i] && 1+c[j] < c[i])
						c[i] = c[j]+1;
				}
			}
		}
		
		return c[n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str =  "ababbbabbababa";
		System.out.println(palindromePartition(str));
	}

}
