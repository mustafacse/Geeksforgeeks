package org.mohsin.geek.String;

public class RankOfString {

	public static int rank(String str){
		
		int rank = 1;
		
		int count[] = new int[256];
		int len = str.length();
		
		for(int i = 0;i < len;++i)
			count[str.charAt(i)]++;
		
		for(int i = 1;i < 256;++i)
			count[i] += count[i-1];
		
		int mul = fact(len);
		for(int i = 0;i < len;++i){
			mul /= (len-i);
			
			rank += (count[str.charAt(i)-1]*mul);
			updateCount(count,str.charAt(i));
		}
		
		return rank;
	}
	
	public static int fact(int n){
		
		int res = 1;
		for(int i = 2;i <= n;++i)
			res *= i;
		return res;
	}
	
	public static void updateCount(int count[],char ch){
		
		for(int i = ch;i < 256;++i)
			--count[i];
	}
	
	public static void main(String[] args) {
		
		String str = "string";
		System.out.println(rank(str));
	}

}
