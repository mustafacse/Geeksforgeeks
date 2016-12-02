package org.mohsin.geek.Array;

public class CountFrequenciesOfElements {

	
	public static void freq(int arr[]){
		
		for(int i = 0;i < arr.length;++i)
			arr[i] -= 1;
		
		int n = arr.length;
		for(int i = 0;i < n;++i)
			arr[arr[i]%n] += n;
		
		for(int i = 0;i < n;++i){
			System.out.println((i+1)+" - "+(arr[i]/n));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int arr[] = {2, 3, 3, 2, 5};
		 freq(arr);
	}

}
