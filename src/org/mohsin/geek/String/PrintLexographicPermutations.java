package org.mohsin.geek.String;


public class PrintLexographicPermutations {

	
	public static void print(String str,int len,char data[],int index){
		
		for(int i = 0;i < len;++i){
			
			data[index] = str.charAt(i);
			if(index == len-1)
			{
				for(int j = 0;j <= index;++j)
					System.out.print(data[j]);
				
				System.out.println();
			}
			else{
				print(str,len,data,index+1);
			}
		}
	}
	
	public static void main(String[] args) {
		
		String str = "AB";
		char data[] = new char[str.length()];
		print(str,str.length(),data,0);

	}

}
