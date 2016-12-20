package org.mohsin.geek.Array;

import java.util.PriorityQueue;

public class MaximumSumAfterKNegations {

	public static int maxSum(int arr[],int k){
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i = 0;i < arr.length;++i)
		{
			q.add(arr[i]);
		}
		
		while(k-- > 0){
			int root = q.poll();
			root *= -1;
			q.add(root);
		}
		
		int sum = 0;
		while(!q.isEmpty()){
			sum += q.poll();
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {-2, 0, 5, -1, 2};
        int k = 4;
        
        System.out.println(maxSum(arr, k));

	}

}
