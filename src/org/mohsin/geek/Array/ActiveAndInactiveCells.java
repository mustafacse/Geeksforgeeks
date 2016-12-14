package org.mohsin.geek.Array;

public class ActiveAndInactiveCells {

	public static void count(int arr[], int k) {

		int temp[] = new int[arr.length];

		for (int i = 0; i < arr.length; ++i)
			temp[i] = arr[i];

		while (k-- > 0) {
			temp[0] = 0 ^ arr[1];
			temp[arr.length - 1] = 0 ^ temp[arr.length - 2];

			for (int i = 1; i <= arr.length - 2; ++i)
				temp[i] = arr[i - 1] ^ arr[i + 1];

			for (int i = 0; i < arr.length; ++i)
				arr[i] = temp[i];
		}

		int active = 0, inActive = 0;

		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == 1)
				++active;
			else
				++inActive;
		}

		System.out.println("Active = " + active + ", InActive = " + inActive);
	}

	public static void main(String[] args) {

		int cells[] = { 0, 1, 0, 1, 0, 1, 0, 1 };
		int k = 3;

		count(cells, k);
	}

}
