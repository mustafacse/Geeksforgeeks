package org.mohsin.geek.Array;

public class CHnageIntoAllSameBits {

	public static boolean isPossible(String str){
		
		int len = str.length();
		
		int sum = 0;
		for(int i = 0;i < len;++i){
			sum += str.charAt(i)-'0';
		}
		
		return (sum == len-1 || sum == 1);
	}
	
	public static void main(String[] args) {
		
		String str = "101";
		if(isPossible(str))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
