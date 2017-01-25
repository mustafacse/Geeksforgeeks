package org.mohsin.geek.Array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SubSet {

	public static void allSubSets(Set<String> res, String str, int arr[], int l, int r) {
		if (res.contains(str) == false) {
			res.add(str);
			str.trim();
		}
		if (l > r)
			return;
		allSubSets(res, str + " " + arr[l], arr, l + 1, r);
		allSubSets(res, str, arr, l + 1, r);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 2 };
		Set<String> res = new HashSet<>();
		String str = "";
		allSubSets(res, str, arr, 0, arr.length - 1);
		Iterator<String> itr = res.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}

}
