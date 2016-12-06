package org.mohsin.geek.Array;

public class AlternatePositiveNegativeArray {

	public static void arrange(int arr[]){
		
		int i = -1;
		for(int j = 0;j < arr.length;++j){
			if(arr[j] < 0){
				++i;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int pos = i+1;
		int neg = 0;
		while(neg <= pos && pos < arr.length && arr[pos] >= 0){
			int temp = arr[pos];
			arr[pos] = arr[neg];
			arr[neg] = temp;
			pos += 1;
			neg += 2;
		}
		
		for(i = 0;i < arr.length;++i)
			System.out.print(arr[i]+" ");
	}
	
	public static void main(String[] args) {
		
		 int arr[] = {2, 3, -4, -1, 6, -9};
		 arrange(arr);

	}

}
