package org.mohsin.geek.Array;

public class RearrangeArray {

	public static void arrangeUtil(int arr[],int i){
		
		int val = -(i+1);
		i = arr[i]-1;
		
		while(arr[i] > 0){
			int new_i = arr[i]-1;
			arr[i] = val;
			val = -(i+1);
			i = new_i;
		}
	}
	
	public static void arrange(int arr[]){
		
		for(int i = 0;i < arr.length;++i)
			++arr[i];
		
		for(int i = 0;i < arr.length;++i){
			if(arr[i] > 0)
				arrangeUtil(arr, i);
		}
		
		for(int i = 0;i < arr.length;++i)
			arr[i] = (-arr[i])-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]  = {2, 0, 1, 4, 5, 3};
		arrange(arr);
		
		for(int i = 0;i < arr.length;++i)
			System.out.print(arr[i]+" ");
	}

}
