package org.mohsin.geek.String;

import java.util.Arrays;

public class PermuteAllInLexographicOrder {

	public static void permute(char str[]){
		
		char data[] = new char[str.length];
		
		permuteHelper(str,data,0,str.length);
		
	}
	
	public static void permuteHelper(char str[],char data[],int index,int len){
		
		if(index == len){
			for(int i  = 0;i < len;++i)
				System.out.print(data[i]);
			System.out.println();
			return;
		}
		
		for(int i = 0;i < len;++i){
			data[index] = str[i];
			permuteHelper(str, data, index+1, len);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char str[] = {'B','A'};
		Arrays.sort(str);
		permute(str);

	}

}
