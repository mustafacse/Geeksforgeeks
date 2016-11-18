package org.mohsin.geek.Hash;

import java.util.HashMap;

public class SubArrayWithSumZero {

	public static boolean check(int arr[]){
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		int sum = 0;
		
		for(int i = 0;i < arr.length;++i){
			
			sum += arr[i];
			if(sum == 0 || arr[i] == 0 || hm.get(sum) != null){
				/*int ind = hm.get(sum);
				System.out.println((ind+1)+" "+i);*/
				return true;
			}
			hm.put(sum, i);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		 int arr[] = {4, 2, -3, 1, 6};
		 if(check(arr))
			 System.out.println("YES");
		 else
			 System.out.println("NO");
	}

}
