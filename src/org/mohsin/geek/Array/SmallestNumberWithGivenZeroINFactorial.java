package org.mohsin.geek.Array;

public class SmallestNumberWithGivenZeroINFactorial {

	public static int binarySearch(int n){
		
		int left = 0;
		int right = n*5;
		
		while(left < right){
			
			int mid = (left+(right-left)/2);
			if(check(mid,n))
				right = mid;
			else
				left = mid+1;
		}
		
		return left;
	}
	
	public static boolean check(int num,int n)
	{
		int temp = num;
		int mul = 5;
		int count = 0;
		
		while(mul < temp){
			
			count += temp/mul;
			mul *= 5;
		}
		
		return count >= n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 6;
		System.out.println(binarySearch(n));
	}

}
