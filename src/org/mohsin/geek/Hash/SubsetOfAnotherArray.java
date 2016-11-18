package org.mohsin.geek.Hash;

import java.util.HashMap;

public class SubsetOfAnotherArray {

	public static boolean isSubset(int arr[],int sub[]){
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i = 0;i < arr.length;++i){
			if(hm.get(arr[i]) == null){
				hm.put(arr[i], 1);
			}
			else{
				int prev = hm.get(arr[i]);
				hm.put(arr[i],prev+1);
			}
		}
		
		for(int i = 0;i < sub.length;++i){
			if(hm.get(sub[i]) == null)
				return false;
			int prev = hm.get(sub[i]);
			if(prev == 1)
				hm.remove(sub[i]);
			else
				hm.put(sub[i], prev-1);
		}
		return true;
	}
	public static void main(String[] args) {
		
		 int arr1[] = {11, 1, 13, 21, 3, 7};
		 int arr2[] = {11, 3, 7, 1};
		 
		 if(isSubset(arr1, arr2))
			 System.out.println("YES");
		 else
			 System.out.println("NO");

	}

}
