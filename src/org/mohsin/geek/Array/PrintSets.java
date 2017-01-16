package org.mohsin.geek.Array;

public class PrintSets {

	public static void printArray(int arr[],int n){
		
		for(int i = 0;i < n;++i){
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
	}
	
	public static void printSets(int n){
		
		int temp[] = new int[n];
		
		temp[0] = n;
		int k = 0;
		
		int remVal = 0;
		
		while(true){
			
			printArray(temp, k+1);
			
			remVal = 0;
			while(k >= 0 && temp[k] == 1){
				remVal += temp[k];
				--k;
			}
			
			if(k < 0) break;
			
			--temp[k];
			++remVal;
			
			while(remVal > temp[k]){
				temp[k+1] = temp[k];
				remVal -= temp[k];
				++k;
			}
			
			temp[k+1] = remVal;
			++k;
		}
	}
	
	
	public static void main(String[] args) {
		
		printSets(5);

	}

}
