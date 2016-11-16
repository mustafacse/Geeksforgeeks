package org.mohsin.geek.Array;

public class LeadersInArray {

	public static void leaders(int arr[])
	{
		int max = arr[arr.length-1];
		System.out.println(max);
		for(int i = arr.length-2;i >= 0;--i){
			if(arr[i] > max)
			{
				System.out.println(arr[i]);
				max = arr[i];
			}
		}
	}
	
	public static void main(String[] args) {
		 int arr[] = {16, 17, 4, 3, 5, 2};
		 leaders(arr);

	}

}
