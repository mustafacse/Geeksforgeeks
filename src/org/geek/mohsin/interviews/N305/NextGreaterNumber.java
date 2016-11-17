package org.geek.mohsin.interviews.N305;

import java.util.Arrays;

public class NextGreaterNumber {

	public static void next(char str[]){
		int i = str.length-2;
		for(;i >= 0;--i){
			if(str[i+1] > str[i])
				break;
		}
		//System.out.println("i = "+i);
		if(i == -1)
			return;
		int smallest = i+1;
		for(int j = i+2;j < str.length;++j){
			if(str[j] < str[smallest]){
				smallest = j;
			}
		}
		
		char temp = str[i];
		str[i] = str[smallest];
		str[smallest] = temp;
		
		Arrays.sort(str, i+1, str.length);
		for(int k = 0;k < str.length;++k){
			System.out.print(str[k]);
		}
		
	}
	public static void main(String[] args) {
		
		char str[] = {'5','3','4','9','7','6'};
		next(str);
		

	}

}
