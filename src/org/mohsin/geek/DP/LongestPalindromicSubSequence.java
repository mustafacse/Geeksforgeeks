package org.mohsin.geek.DP;

public class LongestPalindromicSubSequence {

	public static int recursive(String str,int left,int right){
		
		if(left == right)
			return 1;
		if(left > right) return 0;
	
		if(str.charAt(left) == str.charAt(right))
			return 2+recursive(str, left+1, right-1);
		
		return Integer.max(recursive(str, left, right-1) , recursive(str, left+1, right));
	}
	
	public static int dp(String str){
		
		int n = str.length();
		
		int lps[][] = new int[n][n];
		
		for(int i = 0;i < n;++i)
			lps[i][i] = 1;
		
		for(int len = 2;len <= n;++len){
			for(int i = 0;i < n-len+1;++i){
				int j = i+len-1;

				if(str.charAt(i) == str.charAt(j) && len == 2)
					lps[i][j] = 2;
				else if(str.charAt(i) == str.charAt(j))
					lps[i][j]  = 2+lps[i+1][j-1];
				else
					lps[i][j] = Integer.max(lps[i+1][j], lps[i][j-1]);
			}
		}
		
		return lps[0][n-1];
	}
	
	public static void main(String[] args) {
	
		String str = "GEEKS FOR GEEKS";
		System.out.println(dp(str));
		System.out.println(recursive(str, 0, str.length()-1));
	}

}
