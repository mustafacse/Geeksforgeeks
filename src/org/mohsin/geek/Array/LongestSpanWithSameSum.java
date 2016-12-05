package org.mohsin.geek.Array;

import java.util.Arrays;

public class LongestSpanWithSameSum {

	public static int longestSpan(int arr1[], int arr2[]) {

		int sum[] = new int[2 * arr1.length + 1];
		Arrays.fill(sum, -1);

		int maxLen = 0;
		int prevSum1 = 0, prevSum2 = 0;
		for (int i = 0; i < arr1.length; ++i) {
			prevSum1 += arr1[i];
			prevSum2 += arr2[i];

			int currDiff = prevSum1 - prevSum2;
			int diffIndex = arr1.length + currDiff;

			if (currDiff == 0)
				maxLen = i + 1;
			if (sum[diffIndex] == -1)
				sum[diffIndex] = i;
			else {
				int len = i - sum[diffIndex];
				if (len > maxLen)
					maxLen = len;
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {

		int arr1[] = { 0, 1, 0, 1, 1, 1, 1 };
		int arr2[] = { 1, 1, 1, 1, 1, 0, 1 };
		
		System.out.println(longestSpan(arr1, arr2));

	}

}
