package org.mohsin.geek.Array;

public class MinSteps2ConstructTargetArray {

	public static int minSteps(int arr[]){
		
		int res = 0;
		int i = 0;
		int zeroCount = 0;
		while(true){
			zeroCount = 0;
			for(i = 0;i < arr.length;++i){
				if(arr[i]%2 != 0)
					break;
				if(arr[i] == 0)
					++zeroCount;
			}
			
			if(zeroCount == arr.length)
				break;
			if(i == arr.length){
				for(int j = 0;j < arr.length;++j){
					arr[j] /= 2;
				}
				++res;
			}else{
				for(int j = i;j < arr.length;++j){
					if(arr[j]%2 != 0)
					{
						--arr[j];
						++res;
					}
				}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {16, 16, 16};
		System.out.println(minSteps(arr));

	}

}
