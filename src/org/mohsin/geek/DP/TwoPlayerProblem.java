package org.mohsin.geek.DP;

public class TwoPlayerProblem {

	public static int getSumOfA(int arr[],int i,int j){
		if(i == j)
			return arr[i];
		if(i+1 == j)
			return Integer.max(arr[i],arr[j]);
		if(i > j)
			return Integer.MAX_VALUE;
		return Integer.max(arr[i]+Integer.min(getSumOfA(arr, i+2, j), getSumOfA(arr, i+1, j-1)),
				arr[j]+Integer.min(getSumOfA(arr, i, j-2), getSumOfA(arr, i+1, j-1)));
	}
	
	public static int DP(int arr[]){
		
		int table[][] = new int[arr.length][arr.length];
		
		for(int gap = 0;gap < arr.length;++gap){
			for(int i = 0,j = gap;i < arr.length && j < arr.length;++i,++j){
				int x = (i+2 <= j) ? table[i+2][j] : 0;
				int y = (i+1 <= j-1) ? table[i+1][j-1] : 0;
				int z = (i <= j-2) ? table[i][j-2] : 0;
				
				table[i][j] = Integer.max(arr[i]+Integer.min(x, y), arr[j]+Integer.min(y, z));
			}
		}
		return table[0][arr.length-1];
	}
	
	public static void main(String[] args) {
		
		int arr[] = {8, 15, 3, 7};
		System.out.println(getSumOfA(arr, 0, arr.length-1));
		System.out.println(DP(arr));

	}

}
