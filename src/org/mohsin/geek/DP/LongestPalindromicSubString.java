package org.mohsin.geek.DP;

public class LongestPalindromicSubString {

	public static int LPS(String str){
		
		int n = str.length();
		
		boolean dp[][] = new boolean[n][n];
		
		for(int i = 0;i < n;++i)
			dp[i][i] = true;
		
		int maxLen = 1;
		
		for(int len = 2;len <= n;++len){
			for(int i = 0;i < n-len+1;++i){
				int j = i+len-1;
				
				if(str.charAt(i) == str.charAt(j) && len == 2){
					dp[i][j] = true;
					if(maxLen < 2)
						maxLen = 2;
				}else{
					if(dp[i+1][j-1] && str.charAt(i) == str.charAt(j)){
						dp[i][j] = true;
						if(maxLen < len)
							maxLen = len;
					}
				}
			}
		}
		return maxLen;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "forgeeksskeegfor";
		System.out.println(LPS(str));
	}

}
