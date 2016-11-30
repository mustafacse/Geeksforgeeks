package org.mohsin.geek.String;

public class AreAnagrams {

	
	public static boolean check(String first,String second){
		
		int count[] = new int[256];
		if(first.length() != second.length())
			return false;
		int len = first.length();
		for(int i = 0;i < len;++i){
			count[first.charAt(i)]++;
			count[second.charAt(i)]--;
		}
		
		for(int i = 0;i < 256;++i)
			if(count[i] != 0)
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		
		String first = "geeksforgeeks";
		String second = "forgeeksgeeks";
		
		if(check(first, second))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
