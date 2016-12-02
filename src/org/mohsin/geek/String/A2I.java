package org.mohsin.geek.String;

public class A2I {

	public static int myA2i(String str){
		
		int num = 0;
		int len = str.length();
		for(int i = 0;i < len;++i){
			num = num*10 + (str.charAt(i)-'0');
		}
		return num;
	}
	
	public static void main(String[] args) {
		
		String str = "123";
		System.out.println(myA2i(str));

	}

}
