package org.mohsin.geek.Array;

public class FindTwoRepeatedElements {

	public static void findNumbers(int arr[])
	{
		int xor = 0;
		for(int i = 0;i < arr.length;++i){
			xor ^= arr[i];
		}
		
		int n = arr.length-2;
		for(int i = 1;i <= n ;++i){
			xor ^= i;
		}
		
		int setBit = xor & ~(xor-1);
		int x = 0, y = 0;
		
		for(int i = 0;i < arr.length;++i){
			if((arr[i] & setBit) > 0)
				x ^= arr[i];
			else
				y ^= arr[i];
		}
		
		for(int i = 1;i <= n;++i)
		{
			if((i & setBit) > 0)
				x ^= i;
			else
				y ^= i;
		}
		
		System.out.println(x + " " + y);
	}
	public static void main(String[] args) {
		
		int arr[] = {4, 2, 4, 5, 2, 3, 1};
		findNumbers(arr);
	}

}
