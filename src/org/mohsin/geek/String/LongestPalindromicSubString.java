package org.mohsin.geek.String;

public class LongestPalindromicSubString {

	public static void lps(String str){
		
		int len = str.length();
		boolean table[][] = new boolean[len][len];
		
		for(int i = 0;i < len;++i)
			table[i][i] = true;
		
		int maxLength = 1;
		int start = 0;
		
		for(int i = 0;i < len-1;++i)
		{
			if(str.charAt(i) == str.charAt(i+1))
			{
				table[i][i+1] = true;
				maxLength = 2;
				start = i;
			}
		}
		
		for(int k = 3;k <= len;++k){
			for(int i = 0;i < len-k+1;++i){
				int j = i+k-1;
				if(table[i+1][j-1] && str.charAt(i) == str.charAt(j)){
					table[i][j] = true;
					if(k > maxLength){
						maxLength = k;
						start = i;
					}
				}
			}
		}
		
		System.out.println(start+" "+(start+maxLength-1));
	}
	
	public static void main(String[] args) {
		
		String str =  "forgeeksskeegfor";
		lps(str);

	}

}
