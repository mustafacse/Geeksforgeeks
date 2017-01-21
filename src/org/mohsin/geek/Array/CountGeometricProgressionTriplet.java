package org.mohsin.geek.Array;

public class CountGeometricProgressionTriplet {

	public static void printGP(int arr[]){
		
		for(int j = 1;j < arr.length-1;++j){
			
			int i = j-1;
			int k = j+1;
			
			while(i >= 0 && k < arr.length){
				
				if(arr[j]%arr[j] ==0  && arr[k]%arr[j] == 0
					&& arr[j]/arr[i] == arr[k]/arr[j]){
					System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
					--i;
					++k;
				}else if(arr[j]%arr[i] == 0 && arr[k]%arr[j] == 0){
					if(arr[j]/arr[i] < arr[k]/arr[j])
						--i;
					else
						++k;
				}else if(arr[j]%arr[i] == 0)
					++k;
				else 
					--i;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1, 2, 4, 16};
		printGP(arr);
	}

}
