package org.mohsin.geek.Array;

public class MaxSumPathInTwoArrays {

	public static int maxSum(int a[],int b[]){
		
		int sum1 = 0,sum2 = 0;
		int res = 0;
		
		int i = 0,j = 0;
		while(i < a.length && j < b.length){
			if(a[i] < b[j])
				sum1 += a[i++];
			else if(a[i] > b[j])
				sum2 += b[j++];
			else
			{
				res += Math.max(sum1, sum2);
				while(i < a.length && j < b.length && a[i] == b[j])
				{
					res += a[i++];
					++j;
				}
				sum1 = sum2 = 0;
			}
		}
		
		while(i < a.length)
			sum1 += a[i++];
		
		while(j < b.length)
			sum2 += b[j++];
		
		res += Math.max(sum1, sum2);
		return res;
	}
	
	public static void main(String[] args) {
		
		int ar1[] = {2, 3, 7, 10, 12}, ar2[] = {1, 5, 7, 8};
		System.out.println(maxSum(ar1, ar2));

	}

}
