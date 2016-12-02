package org.mohsin.geek.Array;

public class PrintMissingElementsInRange {

	public static void missingElements(int arr[], int range) {

		boolean isPresent[] = new boolean[range];

		for (int i = 0; i < arr.length; ++i)
			if (arr[i] < range)
				isPresent[arr[i]] = true;

		int i = 0;
		while (i < range) {
			if (isPresent[i] == false) {
				int j = i + 1;
				while (j < range && isPresent[j] == false)
					++j;
				if (j == i + 1)
					System.out.println(i);
				else
					System.out.println(i + "-" + (j - 1));
				i = j;
			} else
				++i;
		}
	}

	public static void main(String[] args) {

		int arr[] = { 88, 105, 3, 2, 200, 0, 10 };
		missingElements(arr, 100);

	}

}
