package org.mohsin.geek.String;

public class AllPossibleStringsWithPlacingSpaces {
	
	public static void printPossibleStrings(String str,char data[],int left,int index,int n){
		
		if(left == n){
			for(int i = 0;i < index;++i)
				System.out.print(data[i]);
			System.out.println();
			return;
		}
		
		data[index] = str.charAt(left);
		printPossibleStrings(str, data, left+1, index+1, n);
		
		data[index] = ' ';
		data[index+1] = str.charAt(left);
		printPossibleStrings(str, data, left+1, index+2, n);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC";
		int len = str.length();
		
		char data[] = new char[2*len];
		
		data[0] = str.charAt(0);
		
		printPossibleStrings(str, data, 1, 1, len);
	}

}
