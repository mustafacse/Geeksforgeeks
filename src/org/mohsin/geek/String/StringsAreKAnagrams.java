package org.mohsin.geek.String;

public class StringsAreKAnagrams {

	public static boolean kAnagrams(String str1,String str2,int k){
		
		int count[] = new int[256];
		
		if(str1.length() != str2.length())
			return false;
		
		int len1 = str1.length();
		for(int i = 0;i < len1;++i)
			count[str1.charAt(i)]++;
		
		int diff = 0;
		for(int i = 0;i < len1;++i){
			if(count[str2.charAt(i)] > 0)
				--count[str2.charAt(i)];
			else
				++diff;
			if(diff > k)
				return false;
		}
		
		return true;
	}
	
	public static void main(String args[]){
		
		String str1 = "fodr";
		String str2 = "gork";
		
		int k = 2;
		
		if(kAnagrams(str1, str2, k))
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
