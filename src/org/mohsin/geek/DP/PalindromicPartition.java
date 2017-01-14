package org.mohsin.geek.DP;

public class PalindromicPartition {

	public static boolean isPalindrome(String str,int left,int right){
		if(left == right)
			return true;
		while(left < right){
			if(str.charAt(left) != str.charAt(right))
				return false;
			++left;
			--right;
		}
		return true;
	}
	
	public static int recursive(String str,int left,int right){
		
		if(left == right)
			return 0;
		if(isPalindrome(str, left, right))
			return 0;
		
		int res = Integer.MAX_VALUE;
		
		for(int k = left;k < right;++k)
		{
			res = Integer.min(res, recursive(str, left, k)+recursive(str, k+1, right)+1);
		}
		
		return res;
	}
	
	
	
	public static int dp(String str){
		
		int n = str.length();
		
		boolean dp[][] = new boolean[n][n];
		int cut[][] = new int[n][n];
		
		for(int i = 0;i < n;++i){
			dp[i][i] = true;
			cut[i][i] = 0;
		}
		
		for(int len = 2;len <= n;++len){
			for(int i = 0;i < n-len+1;++i){
				int j = i+len-1;
				if(str.charAt(i) == str.charAt(j) && len == 2)
					dp[i][j] = true;
				else
					dp[i][j] = str.charAt(i)==str.charAt(j)&&dp[i+1][j-1];
				
				if(dp[i][j])
					cut[i][j] = 0;
				else{
					cut[i][j] = Integer.MAX_VALUE;
					for(int k = i;k < j;++k){
						cut[i][j] = Integer.min(cut[i][j], cut[i][k]+cut[k+1][j]+1);
					}
				}
			}
		}
		
		return cut[0][n-1];
	}
	
	public static int dpOptimized(String str){
		
		int n = str.length();
		
		boolean dp[][] = new boolean[n][n];
		
		for(int i = 0;i < n;++i)
			dp[i][i] = true;
		
		for(int len = 2;len <= n;++len){
			for(int i = 0;i < n-len+1;++i){
				int j = i+len-1;
				
				if(str.charAt(i) == str.charAt(j) && len == 2)
					dp[i][j] = true;
				else
					dp[i][j] = str.charAt(i)==str.charAt(j)&&dp[i+1][j-1];
			}
		}
		
		int cut[] = new int[n];
		
		for(int i = 0;i < n;++i){
			if(dp[0][i])
				cut[i] = 0;
			else{
				cut[i] = Integer.MAX_VALUE;
				
				for(int j = 0;j < i;++j){
					if(dp[j+1][i] && 1+cut[j] < cut[i])
						cut[i] = cut[j]+1;
				}
			}
		}
		return cut[n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str =  "ababbbabbababa";
		
		System.out.println(dp(str));
		System.out.println(recursive(str, 0, str.length()-1));
		System.out.println(dpOptimized(str));
	}

}
