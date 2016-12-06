package org.mohsin.geek.Array;

public class FindLostElement {

	public static int find(int arr1[], int arr2[]) {

		if (arr1.length != arr2.length + 1 && arr2.length != arr1.length + 1)
			return -1;

		int res = 0;
		for (int i = 0; i < arr1.length; ++i)
			res ^= arr1[i];

		for (int i = 0; i < arr2.length; ++i)
			res ^= arr2[i];

		return res;

	}

	public static void main(String[] args) {

		int arr1[] = { 1, 4, 5, 7, 9 };
		int arr2[] = { 4, 5, 7, 9 };

		System.out.println(find(arr1,arr2));
	}

}
