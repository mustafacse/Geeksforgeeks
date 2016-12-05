package org.mohsin.geek.Array;

public class ReorderArrayAcc2GivenIndex {

	public static void arrange(int arr[],int index[])
	{
		for(int i = 0;i < arr.length;++i){
			while(index[i] != i){
				int oldIndex = index[index[i]];
				int oldEle = arr[index[i]];
				
				index[index[i]] = index[i];
				arr[index[i]] = arr[i];
				
				arr[i] = oldEle;
				index[i] = oldIndex;
			}
		}
	}
	
	
	public static void main(String[] args) {
	
		 int arr[] = {50, 40, 70, 60, 90};
		 int index[] = {3,  0,  4,  1,  2};
		 
		 arrange(arr, index);
		 
		 for(int i = 0;i < arr.length;++i){
			 System.out.print(arr[i]+" ");
		 }
		 System.out.println();
		 for(int i = 0;i < index.length;++i){
			 System.out.print(index[i]+" ");
		 }

	}

}
