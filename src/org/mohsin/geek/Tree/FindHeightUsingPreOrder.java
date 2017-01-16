package org.mohsin.geek.Tree;

public class FindHeightUsingPreOrder {

	private static int index = 0;
	
	public static int height(String str,int n){
		
		if(index >= n || str.charAt(index) == 'l')
			return 0;
		
		++index;
		int left = height(str,n);
		++index;
		int right = height(str,n);
		
		return Integer.max(left, right)+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "nlnnlll";
		System.out.println(height(str, str.length()));
	}

}
