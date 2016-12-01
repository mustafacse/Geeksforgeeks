package org.mohsin.geek.DP;

public class LongestCommonSubsequence {

	public static int lcs(String x,String y){
		
		int table[][] = new int[x.length()+1][y.length()+1];
		
		int m = x.length();
		int n = y.length();
		
		for(int i = 0;i <= m;++i){
			for(int j = 0;j <= n;++j){
				if(i == 0 || j == 0)
					table[i][j] = 0;
				else if(x.charAt(i-1) == y.charAt(j-1))
					table[i][j] = table[i-1][j-1]+1;
				else
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
			}
		}
		return table[m][n];
	}
	
	public static void main(String[] args) {
		
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		System.out.println(lcs(str1, str2));

	}

}
