package org.mohsin.geek.Array;

import java.util.ArrayList;

public class MiddlePointInSortedArray {

	public static int middlePoint(int arr[]){
		
		int count = 0;
		
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i = 0;i < arr.length;++i){
			++count;
			res.add(arr[i]);
			int j = i+1;
			while(j < arr.length && arr[i] == arr[j])
				++j;
			if(j == arr.length)
				break;
			i = j-1;
		}
		
		if(count%2 != 0)
			return res.get(res.size()/2);
		return -1;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4, 4, 5, 6, 6, 6, 7};
		System.out.println(middlePoint(arr));
	}

}
