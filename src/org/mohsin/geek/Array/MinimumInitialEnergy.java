package org.mohsin.geek.Array;

public class MinimumInitialEnergy {

	public static int minEnergy(int arr[]){
		
		int curr = 0;
		int init = 0;
		
		boolean flag = false;
		
		for(int i = 0;i < arr.length;++i)
		{
			curr += arr[i];
			
			if(curr <= 0){
				init += Math.abs(curr)+1;
				curr = 1;
				flag = true;
			}
		}
		
		return flag ? init : 1;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {4, -10, 4, 4, 4};
		System.out.println(minEnergy(arr));

	}

}
