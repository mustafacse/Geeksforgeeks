package org.mohsin.geek.String;

public class CountNumberOfWords {

	public static int countWords(String str){
		
		int len = str.length();
		
		int index = 0;
		
		int res = 0;
		int state = 0;
		
		while(index < len){
			
			if(str.charAt(index) == ' ')
				state = 0;
			else if(state == 0){
				state = 1;
				++res;
			}
			++index;
		}
		
		return res;
	}
	
	
	public static void main(String args[]){
		
		String str = "   I Love    coding sleep and and codind :D ";
		
		System.out.println(countWords(str));
		
	}
}
