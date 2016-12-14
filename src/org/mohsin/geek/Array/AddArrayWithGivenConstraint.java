package org.mohsin.geek.Array;

import java.util.ArrayList;
import java.util.Iterator;

public class AddArrayWithGivenConstraint {

	public static void split(int sum, ArrayList<Integer> res) {

		if(sum == 0)
			return;
		
		int rem = sum%10;
		sum /= 10;
		split(sum,res);
		res.add(rem);
	}

	public static void add(int arr1[], int arr2[]) {

		ArrayList<Integer> res = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {
			int sum = arr1[i] + arr2[j];
			if (sum < 10)
				res.add(sum);
			else {
				split(sum, res);
			}
			++i;
			++j;
		}

		while (i < arr1.length) {
			if (arr1[i] < 10)
				res.add(arr1[i]);
			else
				split(arr1[i], res);
			++i;
		}

		while (j < arr2.length) {
			if (arr2[j] < 10)
				res.add(arr2[j]);
			else
				split(arr2[j], res);
			++j;
		}

		Iterator<Integer> itr = res.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + ", ");
		}
	}

	public static void main(String[] args) {

		int arr1[] = { 9343, 2, 3, 7, 9, 6 };
		int arr2[] = { 34, 11, 4, 7, 8, 7, 6, 99 };

		add(arr1, arr2);
	}

}
