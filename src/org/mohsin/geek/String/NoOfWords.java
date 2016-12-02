package org.mohsin.geek.String;

public class NoOfWords {

	public static int countWords(String str){
		
		int len = str.length();
		int i = 0;
		
		int count = 0;
		while(i < len){
			if(str.charAt(i) != ' '){
				++count;
				while(i < len && str.charAt(i) != ' ')
					++i;
			}else{
				++i;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		String str = "    I love coding";
		System.out.println(countWords(str));

	}

}
