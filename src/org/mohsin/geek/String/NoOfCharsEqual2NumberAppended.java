package org.mohsin.geek.String;

public class NoOfCharsEqual2NumberAppended {

	public static boolean isEqual(String str){
		
		int len = str.length();
		
		int digits = 0;
		
		for(int i = len;i > 0;i /= 10)
			++digits;
		
		int num = 0;
		
		for(int i = len-digits;i < len;++i){
			char ch = str.charAt(i);
			if(ch >= '0' && ch <= '9')
				num = num*10 + ch-'0';
			else
				return false;
		}
		
		return num == len-digits;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geeks5";
		if(isEqual(str))
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
