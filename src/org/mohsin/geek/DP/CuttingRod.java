package org.mohsin.geek.DP;

public class CuttingRod {

	public static int recursive(int price[],int n){
		
		if(n <= 0)
			return 0;
		
		int maxVal = Integer.MIN_VALUE;
		
		for(int i = 0;i < n;++i)
			maxVal = Integer.max(maxVal, price[i]+recursive(price, n-i-1));
		
		return maxVal;
	}
	
	public static int dp(int price[],int n){
		
		int val[] = new int[n+1];
		
		val[0] = 0;
		int res = 0;
		
		for(int i = 1;i <= n;++i){
			res = Integer.MIN_VALUE;
			for(int j = 0;j < i;++j){
				res = Integer.max(res, price[j]+val[i-j-1]);
			}
			val[i] = res;
		}
		
		return val[n];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		 
		 System.out.println(recursive(arr, arr.length));
		 System.out.println(dp(arr, arr.length));
	}

}
