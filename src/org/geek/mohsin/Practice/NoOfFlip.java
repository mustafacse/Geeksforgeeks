/**
 * 
 */
package org.geek.mohsin.Practice;

/**
 * @author mohsin
 *
 */
public class NoOfFlip {

	public static int noOfFlip(String str,char expected){
		
		if(str.length() == 0)
			return 0;
		
		int count = 0;
		int len = str.length();
		for(int i = 0;i < len;++i){
			if(str.charAt(i) != expected)
				++count;
			expected = expected == '1' ? '0' : '1';
		}
		return count;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "001";
		System.out.println(Math.min(noOfFlip(str, '0'), noOfFlip(str, '1')));

	}

}
