package org.mohsin.geek.String;

public class PrintLongestCommonSubSequence {

	public static void print(String str1,String str2){
		
		int m = str1.length();
		int n = str2.length();
		
		int lcs[][] = new int[m+1][n+1];
		for(int i = 0;i <= m;++i){
			for(int j = 0;j <= n;++j){
				if(i == 0 || j == 0)
					lcs[i][j] = 0;
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					lcs[i][j] = 1+lcs[i-1][j-1];
				else
					lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
			}
		}
		
		StringBuilder str = new StringBuilder();
		int i = m,j = n;
		while(i > 0 && j > 0){
			if(str1.charAt(i-1) == str2.charAt(j-1)){
				str.append(str1.charAt(i-1));
				--i;
				--j;
			}else {
				if(lcs[i-1][j] > lcs[i][j-1])
					--i;
				else
					--j;
			}
			
		}
		
		System.out.println(str.reverse());
	}
	
	public static void main(String[] args) {
		
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		
		print(str1,str2);
	}

}
