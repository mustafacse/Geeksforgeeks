package org.mohsin.geek.Array;

public class AbsoluteDistinctCount {

	public static int distinct(int arr[]){
		
		int count = arr.length;
		int i = 0,j = arr.length-1;
		while(i < j){
			while(i != j && arr[i] == arr[i+1]){
				--count;
				++i;
			}
			
			while(i != j && arr[j] == arr[j-1]){
				--count;
				++j;
			}
			
			if(i == j)
				break;
			int sum = arr[i]+arr[j];
			if(sum == 0){
				--count;
				++i;
				--j;
			}else if(sum < 0)
				++i;
			else
				--j;
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {-3,-2,0,3,4,5};
		System.out.println(distinct(arr));

	}

}
