package org.mohsin.geek.Hash;

public class LargestSubArrayWithEqualZeroAndOnes {

	public static void findlargestSubArray(int arr[]){
		
		int startIndex = -1;
		int maxLength = Integer.MIN_VALUE;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int leftSum[] = new int[arr.length];
		leftSum[0] = arr[0] == 0 ? -1 : 1;
		
		min = max = leftSum[0];
		
		for(int i = 1;i < arr.length;++i){
			
			leftSum[i] = leftSum[i-1] + (arr[i] == 0 ? -1 : 1);
			if(leftSum[i] < min)
				min = leftSum[i];
			if(leftSum[i] > max)
				max = leftSum[i];
		}
		
		int map[] = new int[max-min+1];
		for(int i = 0;i < map.length;++i)
				map[i] = -1;
		
		for(int i = 0;i < leftSum.length;++i){
			if(leftSum[i] == 0){
				startIndex = 0;
				maxLength = i+1;
			}else{
				
				if(map[leftSum[i]-min] == -1)
					map[leftSum[i]-min] = i;
				else{
					if(i-map[leftSum[i]-min] > maxLength){
						maxLength = i-map[leftSum[i]-min];
						startIndex = map[leftSum[i]-min]+1;
					}
				}
			}
		}
		
		if(startIndex != -1)
			System.out.println("start = "+startIndex+" end = "+(maxLength+startIndex-1));
	}
	public static void main(String[] args) {
		 int arr[] =  {1, 0, 0, 1, 0, 1, 1};
		 findlargestSubArray(arr);
	}

}
