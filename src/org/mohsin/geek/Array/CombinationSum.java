package org.mohsin.geek.Array;

import java.util.Arrays;
import java.util.Vector;

public class CombinationSum {

	private static Vector<Vector<Integer>> res = new Vector<>();

	public static boolean subSet(int arr[], int sum, int visited[]) {

		if (sum == 0)
			return true;

		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] <= sum && visited[i] == -1) {
				visited[i] = i;
				if (subSet(arr, sum - arr[i], visited)) {
					for (int k = 0; k < arr.length; ++k) {
						if (visited[k] != -1 && visited[k] != Integer.MAX_VALUE)
							System.out.print(arr[k] + " ");
						visited[k] = Integer.MAX_VALUE;
					}
					System.out.println();
					return true;
				}
				visited[i] = -1; // backtrack
			}
		}
		return false;
	}

	public static void allSubSets(int arr[], int sum, int index, Vector<Integer> v) {

		if (index >= arr.length)
			return;
		if (sum == 0){
			res.addElement(v);
			v.clear();
			return;
		}
		else if (sum < 0) {
			v.clear();
			return;
		} else {
			v.addElement(arr[index]);
			allSubSets(arr, sum - arr[index], index + 1, v);
			v.removeElement(arr[index]);
			allSubSets(arr, sum, index + 1, v);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
		int visited[] = new int[arr.length];
		Arrays.fill(visited, -1);
		subSet(arr, 8, visited);
		Vector<Integer> v = new Vector<>();

		allSubSets(arr, 8, 0, v);
		
		for(int i = 0;i < res.size();++i){
			Vector<Integer> temp = res.get(i);
			for(int j = 0;j < temp.size();++j){
				System.out.print(temp.get(j)+" ");
			}
		}
	}

}
