package org.mohsin.geek.String;

public class CheckForAnagrams {

	public static boolean areAnagrams(String str1,String str2){
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		if(len1 != len2)
			return false;
		
		int count[] = new int[256];
		
		for(int i = 0;i < len1;++i){
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}
		
		for(int i = 0;i < 256;++i){
			if(count[i] != 0)
				return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "geeksforgeeks";
		String str2 = "forgeeksgeeks";
		
		if(areAnagrams(str1, str2))
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
