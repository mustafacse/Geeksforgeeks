package org.mohsin.geek.Matrix;

import java.util.Arrays;

public class MaxSumRactangle {

	private static int start = 0,finish = -1;
	
	public static int kadane(int temp[]){
		
		int localStart = 0;
		int sum = 0;
		int maxSoFar = 0;
		
		for(int i = 0;i < temp.length;++i){
			sum += temp[i];
			if(sum < 0){
				sum = 0;
				localStart = i+1;
			}else if(sum > maxSoFar){
				maxSoFar = sum;
				start = localStart;
				finish = i;
			}
		}
		
		if(finish != -1)
			return maxSoFar;
		
		int maxElement = temp[0];
		start = finish = 0;
		
		for(int i = 1;i < temp.length;++i)
		{
			if(temp[i] > maxElement)
			{
				maxElement = temp[i];
				start = finish = i;
			}
		}
		return maxElement;
	}
	
	public static void maxSumRactangle(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		int temp[] = new int[row];
		
		int finalLeft = 0,finalRight = 0,finalStart = 0,finalEnd = 0;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		
		for(int left = 0;left < col;++left){
			
			Arrays.fill(temp, 0);
			
			for(int right = left;right < col;++right){
				
				for(int i = 0;i < row;++i)
					temp[i] += mat[i][right];
				
				sum = kadane(temp);
				
				if(sum > maxSum){
					maxSum = sum;
					finalLeft = left;
					finalRight = right;
					finalStart = start;
					finalEnd = finish;
				}
			}
		}
		
		System.out.println(finalStart+", "+finalLeft);
		System.out.println(finalEnd+", "+finalRight);
		
	}
	
	public static void main(String[] args) {
		
		 int M[][] = {{1, 2, -1, -4, -20},
                 {-8, -3, 4, 2, 1},
                 {3, 8, 10, 1, 3},
                 {-4, -1, 1, 7, -6}
                };
		 
		 maxSumRactangle(M);

	}

}
