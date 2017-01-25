package org.mohsin.geek.DP;

public class SubSetSujmProblem {

	public static boolean recursive(int arr[], int n, int sum) {

		if (sum == 0)
			return true;
		if (n == 0)
			return sum == 0;
		if (arr[n - 1] > sum)
			return recursive(arr, n - 1, sum);
		return recursive(arr, n - 1, sum) || recursive(arr, n - 1, sum - arr[n - 1]);
	}

	public static boolean dp(int arr[], int n, int sum) {

		boolean table[][] = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; ++i)
			table[0][i] = true;
		for (int i = 1; i <= sum; ++i)
			table[i][0] = false;

		for (int i = 1; i <= sum; ++i) {
			for (int j = 1; j <= n; ++j) {
				table[i][j] = table[i][j-1];
				if (arr[j - 1] <= i) {
					table[i][j] = table[i][j] || table[i - arr[j - 1]][j - 1];
				}
			}
		}
		return table[sum][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		System.out.println(recursive(set, set.length, sum));
		System.out.println(dp(set, set.length, sum));
	}

}
