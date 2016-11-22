/**
 * 
 */
package org.mohsin.geek.String;

/**
 * @author mohsin
 *
 */
public class PrintAllPermutation {

	public static void permute(char str[],int l,int r){
		
		if(l == r)
		{
			System.out.println(str);
			return;
		}
		
		for(int i = l;i <= r;++i){
			char temp = str[l];
			str[l] = str[i];
			str[i] = temp;
			
			permute(str,l+1,r);
			
			temp = str[l];
			str[l] = str[i];
			str[i] = temp;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		char str[] = {'A','B','C'};
		permute(str, 0, str.length-1);

	}

}
