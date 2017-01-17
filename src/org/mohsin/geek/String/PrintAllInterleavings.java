package org.mohsin.geek.String;

public class PrintAllInterleavings {

	public static void printInterleavings(String str1,String str2,char data[],int m,int n,int len1,int len2,int index){
		
		if(m == len1 && n == len2){
			for(int i = 0;i < data.length;++i)
				System.out.print(data[i]);
			System.out.println();
		}
		
		if(m != len1){
			data[index] = str1.charAt(m);
			printInterleavings(str1, str2, data, m+1, n, len1, len2, index+1);
		}
		
		if(n != len2){
			data[index] = str2.charAt(n);
			printInterleavings(str1, str2, data, m, n+1, len1, len2, index+1);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "AB";
		String str2 = "CD";
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		char data[] = new char[len1+len2];
		printInterleavings(str1, str2, data, 0, 0, len1, len2, 0);
	}

}
