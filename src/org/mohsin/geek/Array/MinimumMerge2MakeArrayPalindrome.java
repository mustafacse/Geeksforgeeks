package org.mohsin.geek.Array;

public class MinimumMerge2MakeArrayPalindrome {

	public static int minMerge(int arr[]){
		
		int i = 0,j = arr.length-1;
		int ans = 0;
		for(;i<=j;){
			if(arr[i] == arr[j]){
				++i;
				--j;
			}else{
				if(arr[i] > arr[j]){
					--j;
					arr[j] += arr[j+1];
					++ans;
				}else{
					++i;
					arr[i] += arr[i-1];
					++ans;
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1, 4, 5, 9, 1};
		System.out.println(minMerge(arr));
	}

}
