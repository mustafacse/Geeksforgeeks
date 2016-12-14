package org.mohsin.geek.Array;

public class JollyJumperSequence {

	public static boolean isJolly(int arr[]){
		
		boolean dp[] = new boolean[arr.length];
		
		for(int i = 0;i < arr.length-1;++i){
			
			int diff = Math.abs(arr[i]-arr[i+1]);
			if(diff == 0 || diff > arr.length-1 || dp[diff])
				return true;
			dp[i] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int a[] = {11, 7, 4, 2, 1, 6};
		if(isJolly(a))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
