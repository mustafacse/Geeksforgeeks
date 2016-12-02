package org.mohsin.geek.String;

public class PhoneaDigits {

	public static String digits[] = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	
	public static void print(String str,char output[],int curr){
		
		if(curr == str.length())
		{
			for(int i = 0;i < curr;++i)
				System.out.print(output[i]);
			System.out.print(" ");
			return;
		}
		
		for(int i = 0;i < digits[str.charAt(curr)-'0'].length();++i){
			output[curr] = digits[str.charAt(curr)-'0'].charAt(i);
			print(str,output,curr+1);
			if(str.charAt(curr) == '0' || str.charAt(curr) == '1')
				return;
		}
	}
	
	public static void main(String[] args) {
		
		char output[] = new char[100];
		print("234",output,0);

	}

}
