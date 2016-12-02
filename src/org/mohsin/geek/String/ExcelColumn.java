package org.mohsin.geek.String;

public class ExcelColumn {

	public static void printString(int n) {

		StringBuilder str = new StringBuilder();

		while (n > 0) {

			int rem = n % 26;

			if (rem == 0) {
				str.append('Z');
				n = (n / 26) - 1;
			} else {
				str.append((char)((rem-1)+'A'));
				n = n / 26;
			}
		}
		
		System.out.println(str.reverse());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printString(26);
		printString(51);
		printString(52);
		printString(80);
		printString(676);
		printString(702);
		printString(705);
	}

}
