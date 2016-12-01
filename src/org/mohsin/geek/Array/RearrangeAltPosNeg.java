package org.mohsin.geek.Array;

public class RearrangeAltPosNeg {

	public static void rightRotate(int arr[],int outIndex,int curr){
		
		int temp = arr[curr];
		for(int i = curr;i > outIndex;--i)
			arr[i] = arr[i-1];
		arr[outIndex] = temp;
	}
	
	public static void arrange(int arr[]){
		
		int outIndex = -1;
		
		for(int i = 0;i < arr.length;++i){
			
			if(outIndex >= 0){
				
				if(arr[outIndex] < 0 && arr[i] >= 0 || arr[outIndex] >= 0 && arr[i] < 0){
					rightRotate(arr,outIndex,i);
					
					if(i-outIndex > 2)
						outIndex += 2;
					else
						outIndex = -1;
				}
			}
			
			if(outIndex == -1){
				if(arr[i] >= 0 && i%2 == 0 || arr[i] < 0 && i%2 != 0)
					outIndex = i;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		arrange(arr);
		
		for(int i = 0;i < arr.length;++i)
			System.out.print(arr[i]+" ");

	}

}
