package org.mohsin.geek.DP;

public class LongestContiguosSubArray {

	public static void LCSubArray(int arr[]){
		
		int currMax = 0;
		int max = 0;
		int start = 0,end = 0;
		int s = 0;
		
		for(int i = 0;i < arr.length;++i){
			
			currMax += arr[i];
			
			if(currMax < 0){
				currMax = 0;
				s = i+1;
			}else
			{
				if(currMax > max){
					max = currMax;
					start = s;
					end = i;
				}
			}
		}
		
		System.out.println("Max Sum = "+max);
		System.out.println(start+" "+end);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		 
		 LCSubArray(a);
	}

}
