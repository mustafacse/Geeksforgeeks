package org.mohsin.geek.Array;

public class ConvertIntoZigZagArray {

	public static void convertor(int arr[]){
		
		boolean flag = true;
		for(int i = 0;i < arr.length-1;++i){
			if(flag){
				if(arr[i] > arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}else{
				if(arr[i] < arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			
			flag = !flag;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {4, 3, 7, 8, 6, 2, 1};
		convertor(arr);
		
		for(int i = 0;i < arr.length;++i)
			System.out.print(arr[i]+" ");

	}

}
