package org.mohsin.geek.String;

public class GenerateAllBinaryStrings {

	public static void generateStrings(char str[],int n,int k){
		
		if(k == n){
			for(int i = 0;i < n;++i)
				System.out.print(str[i]);
			System.out.println();
			return;
		}
		
		if(str[n-1] == '1'){
			str[n] = '0';
			generateStrings(str, n+1, k);
		}else{
			str[n] = '0';
			generateStrings(str, n+1, k);
			str[n] = '1';
			generateStrings(str, n+1, k);
		}
	}
	
	
	public static void main(String[] args) {
		
		int k = 3;
		char str[] = new char[3];
		str[0] = '0';
		generateStrings(str, 1, k);
		str[0] = '1';
		generateStrings(str, 1, k);

	}

}
