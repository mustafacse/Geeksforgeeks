package org.mohsin.geek.String;



public class MaximumPalindromicSubString {

	/*public static int recursive(String str,int left,int right){
		
		if(left > right)
			return 0;
		if(left == right)
			return 1;
		if(str.charAt(left) == str.charAt(right))
			return 2+recursive(str, left+1, right-1);
		
		return Integer.max(recursive(str, left+1, right), recursive(str, left, right-1));
	}*/
	
	public static int dp(String str){
		
		int n = str.length();
		boolean table[][] = new boolean[n][n];
		
		for(int i = 0;i < n;++i)
			table[i][i] = true;
		for(int i = 0;i < n-1;++i){
			if(str.charAt(i) == str.charAt(i+1))
				table[i][i+1] = true;
		}
		int maxLen = 1;
		int start = -1,end = -1;
		for(int len = 3;len <= n;++len){
			
			for(int i = 0;i < n-len+1;++i){
				
				int j = i+len-1;
				if(table[i+1][j-1] && str.charAt(i) == str.charAt(j)){
					table[i][j] = true;
					if(len > maxLen){
						maxLen = len;
						start = i;
						end = j;
					}
				}
			}
		}
		
		if(maxLen > 1)
		{
			System.out.println("Maximum length of palindromic substring : "+maxLen);
			for(int i = start;i <= end;++i)
				System.out.print(str.charAt(i));
		}
		
		return maxLen;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "forgeeksskeegfor";
		//System.out.println(recursive(str, 0, str.length()-1));
		dp(str);
	}

}
