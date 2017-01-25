package org.mohsin.geek.DP;

public class CountOfNumbersWhoseDigitsSumIsGivenNum {

	public static int count(int n, int sum) {

		int dp[][] = new int[n][sum];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < sum; ++j)
				dp[i][j] = -1;
		}

		int ans = 0;

		for (int i = 1; i <= 9; ++i)
			if (sum - i >= 0)
				ans += recur(n - 1, sum - i, dp);

		return ans;
	}
	
	public static int recur(int n,int sum,int dp[][]){
		
		if(n == 0)
			return sum == 0 ? 1 : 0;
		if(dp[n][sum] != -1)
			return dp[n][sum];
		
		int ans = 0;
		
		for(int i = 0;i <= 9;++i){
			if(sum-i >= 0)
				ans += recur(n-1, sum-i, dp);
		}
		
		return dp[n][sum] = ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2,sum = 5;
		System.out.println(count(n, sum));
	}

}
