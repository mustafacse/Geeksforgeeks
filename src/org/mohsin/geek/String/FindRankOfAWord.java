package org.mohsin.geek.String;

public class FindRankOfAWord {

	public static int fact(int n){
		if(n <= 1)
			return 1;
		return n*fact(n-1);
	}
	
	public static int countSmaller(String str,int index,int len){
		
		char ch = str.charAt(index);
		
		int count = 0;
		
		for(int i = index+1;i < len;++i){
			if(str.charAt(i) < ch)
				++count;
		}
		
		return count;
	}
	
	
	public static int rank(String str){
		
		int res = 1;
		int len = str.length();
		int mul = fact(len);
		
		for(int i = 0;i < len;++i){
			
			mul /= (len-i);
			int countRight = countSmaller(str, i, len);
			res += (mul*countRight);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "cba";
		System.out.println(rank(str));
	}

}
