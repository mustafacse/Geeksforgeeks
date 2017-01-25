package org.mohsin.geek.DP;

public class NoOfStringsWithNoConsecutive1s {

	public static int dp(int n){
		
		int a[] = new int[n];
		int b[] = new int[n];
		
		a[0] = b[0] = 1;
		
		for(int i = 1;i < n;++i){
			a[i] = a[i-1]+b[i-1];
			b[i] = a[i-1];
		}
		
		return a[n-1]+b[n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(dp(n));
	}

}
