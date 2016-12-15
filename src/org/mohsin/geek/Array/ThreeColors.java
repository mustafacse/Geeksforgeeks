package org.mohsin.geek.Array;

public class ThreeColors {

	public static int mix(char str[]){
		
		int rCount = 0,bCount = 0,gCount = 0;
		
		for(int i = 0;i < str.length;++i){
			switch(str[i]){
			case 'R': ++rCount;
			break;
			case 'G': ++gCount;
			break;
			case 'B': ++bCount;
			break;
			}
		}
		
		if(rCount == str.length || bCount == str.length || gCount == str.length)
			return str.length;
		
		if(rCount%2 == 0 && gCount%2 == 0 && bCount%2 == 0)
			return 2;
		if(rCount%2 != 0 && gCount%2 != 0 && bCount%2 != 0)
			return 2;
		return 1;
	}
	
	public static void main(String[] args) {
		
		 char str[] = {'R', 'G', 'B', 'R'};
		 System.out.println(mix(str));
	}

}
