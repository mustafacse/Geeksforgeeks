package org.mohsin.geek.Array;

public class RearrangePosNeg {

	public static void arrange(int arr[]){
		
		int i = -1;
		for(int j = 0;j < arr.length;++j){
			if(arr[j] < 0){
				int temp = arr[++i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int pos = i+1;
		int neg = 0;
		while(pos < arr.length && neg < pos && arr[neg] < 0){
			int temp = arr[pos];
			arr[pos] = arr[neg];
			arr[neg] = temp;
			++pos;
			neg += 2;
		}
	}
	
	public static void main(String[] args) {
		
		int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		arrange(arr);
		
		for(int i = 0;i < arr.length;++i)
			System.out.print(arr[i]+" ");

	}

}
