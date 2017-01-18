package org.mohsin.geek.String;

public class CanBeRepresentedAsRepeatationOfASubString {

	public static int[] LPSArray(String str){
		
		int n = str.length();
		int lps[] = new int[n];
		lps[0] = 0;
		int len = 0;
		int i = 1;
		
		while(i < n){
			if(str.charAt(i) == str.charAt(len)){
				++len;
				lps[i] = len;
				++i;
			}else{
				
				if(len != 0){
					len = lps[len-1];
				}else{
					lps[i] = 0;
					++i;
				}
			}
		}
		
		return lps;
	}
	
	public static boolean isPossible(String str){
		
		int n = str.length();
		
		if(n%2 != 0)
			return false;
		
		int lps[] = LPSArray(str);
		
		int len = lps[n-1];
		
		return len > 0 && n%(n-len) == 0 ? true : false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {"ABCABC", "ABABAB", "ABCDABCD", "GEEKSFORGEEKS",
                "GEEKGEEK", "AAAACAAAAC", "ABCDABC"};
		
		for(int i = 0;i < arr.length;++i){
			if(isPossible(arr[i]))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
