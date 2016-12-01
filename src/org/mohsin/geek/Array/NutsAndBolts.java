package org.mohsin.geek.Array;

public class NutsAndBolts {

	public static void matchPairs(char nuts[],char bolts[],int low,int high){
		
		if(low < high){
			int pivot = partition(nuts,low,high,bolts[high]);
			partition(bolts,low,high,nuts[pivot]);
			
			matchPairs(nuts, bolts, low, pivot-1);
			matchPairs(nuts, bolts, pivot+1, high);
		}
	}
	
	public static int partition(char arr[],int left,int right,char key){
		
		int i = left;
		for(int j = left;j < right;++j){
			if(arr[j] < key){
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				++i;
			}else if(arr[j] == key){
				char temp = arr[right];
				arr[right] =arr[j];
				arr[j] = temp;
				--j;
			}
		}
		
		char temp = arr[i];
		arr[i] = arr[right];
		arr[right] = temp;
		
		return i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
 
        matchPairs(nuts, bolts, 0, nuts.length-1);
        
        for(int i = 0;i < nuts.length;++i){
        	System.out.println(nuts[i]+" "+bolts[i]);
        }
	}

}
