package org.mohsin.geek.String;

public class RunLengthEncoding {

	
	public static String runLengthEncoding(String str){
		
		int count = 1;
		int index = 1;
		int len = str.length();
		
		char ch = str.charAt(0);
		StringBuilder res = new StringBuilder();
		while(index < len){
			while(index < len && ch == str.charAt(index)){
				++index;
				++count;
			}
			res.append(ch+""+count);
			if(index == len)
				break;
			ch = str.charAt(index);
			count = 0;
		}
		return new String(res);
	}
	
	public static void main(String[] args) {
		
		String str = "aaabbcccd";
		System.out.println(runLengthEncoding(str));

	}

}
