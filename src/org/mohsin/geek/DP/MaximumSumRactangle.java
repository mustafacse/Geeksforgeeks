package org.mohsin.geek.DP;

import java.util.Arrays;

public class MaximumSumRactangle {

	private static int start = 0,end = 0;
	
	public static int kadane(int arr[]){
		
		int currSum = 0;
		int maxSumSoFar = 0;
		
		int localStart = 0;
		
		for(int i = 0;i < arr.length;++i){
			currSum += arr[i];
			if(currSum < 0){
				currSum = 0;
				localStart = i+1;
			}else{
				if(maxSumSoFar < currSum){
					maxSumSoFar = currSum;
					start = localStart;
					end = i;
				}
			}
		}
		
		if(end != -1)
			return maxSumSoFar;
		
		maxSumSoFar = arr[0];
		start = end = 0;
		for(int i = 1;i < arr.length;++i){
			if(arr[i] > maxSumSoFar){
				maxSumSoFar = arr[i];
				start = i;
				end = i;
			}
		}
		
		return maxSumSoFar;
	}
	
	public static int maxSumRactabgle(int mat[][]){
		
		int top = -1,bottom = -1;
		int leftCorner = -1,rightCorner = -1;
		
		int temp[] = new int[mat[0].length];
		int maxSum = Integer.MIN_VALUE;
		
		
		for(int left = 0;left < mat[0].length;++left){
			
			Arrays.fill(temp, 0);
			
			for(int right = left;right < mat[0].length;++right){
				
				for(int i = 0;i < mat.length;++i)
					temp[i] += mat[i][right];
				
				int sum = kadane(temp);
				if(sum > maxSum){
					leftCorner = left;
					rightCorner = right;
					top = start;
					bottom = end;
					maxSum = sum;
				}
			}
		}
		
		System.out.println("( "+top+", "+leftCorner+" )");
		System.out.println("( "+bottom+", "+rightCorner+" )");
		
		return maxSum;
	}
	
	
	public static void main(String[] args) {		// TODO Auto-generated method stub

		 int mat[][] = {{1, 2, -1, -4, -20},
                 {-8, -3, 4, 2, 1},
                 {3, 8, 10, 1, 3},
                 {-4, -1, 1, 7, -6}
                };
		 
		 System.out.println(maxSumRactabgle(mat));

	}

}
