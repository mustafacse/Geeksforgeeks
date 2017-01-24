package org.mohsin.geek.Array;

public class PositionAfterStableSort {

	public static int position(int arr[],int idx){
		
		int res = 0;
		
		for(int i = 0;i < arr.length;++i){
			if(arr[i] < arr[idx])
				++res;
			else if(arr[i] == arr[idx] && i < idx)
				++res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 4, 3, 5, 2, 3, 4, 3, 1, 5};
		int idx = 5;
		System.out.println(position(arr, idx));
	}

}
