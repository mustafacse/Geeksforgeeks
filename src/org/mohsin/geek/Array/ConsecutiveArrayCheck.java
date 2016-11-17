package org.mohsin.geek.Array;

public class ConsecutiveArrayCheck {

	public static boolean areConsecutive(int arr[]){
		int max = getMax(arr);
		int min = getMin(arr);
		
		if(max-min+1 == arr.length){
			for(int i = 0;i < arr.length;++i){
				int j = 0;
				if(arr[i] < 0){
					j = -arr[i]-min;
				}else{
					j = arr[i]-min;
				}
				
				if(arr[j] > 0)
					arr[j] = -arr[j];
				else
					return false;
			}
			return true;
		}
		return false;
	}
	
	public static int getMax(int arr[]){
		int max = arr[0];
		for(int i = 1;i < arr.length;++i){
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	
	public static int getMin(int arr[]){
		int min = arr[0];
		for(int i = 1;i < arr.length;++i){
			if(arr[i] < min)
				min = arr[i];
		}
		return min;
	}
	
	public static void main(String[] args) {
	
		int arr[]= {5, 4, 2, 3, 1, 6};
		if(areConsecutive(arr))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
