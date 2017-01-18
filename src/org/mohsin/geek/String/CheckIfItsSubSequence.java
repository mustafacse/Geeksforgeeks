package org.mohsin.geek.String;

public class CheckIfItsSubSequence {

	public static boolean recursive(String str1,String str2,int m,int n){
		
		if(n == 0)
			return true;
		if(m == 0)
			return false;
		if(str1.charAt(m-1) == str2.charAt(n-1))
			return recursive(str1, str2, m-1, n-1);
		
		return recursive(str1, str2, m-1, n);
	}
	
	public static boolean iterative(String str1,String str2,int m,int n){
		
		int j = 0;
		for(int i = 0;i < m;++i){
			if(str1.charAt(i) == str2.charAt(j))
				++j;
		}
		
		return (j == n);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "ADXCPY";
		String str2 = "AXY";
		
		int m = str1.length();
		int n = str2.length();
		
		if(recursive(str1, str2, m, n))
			System.out.println("yes");
		else
			System.out.println("no");
		
		if(iterative(str1, str2, m, n))
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
