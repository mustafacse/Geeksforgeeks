package org.mohsin.geek.Array;

public class Inversion {

	public static int inversionCount(int arr[]){
		
		for(int i = 0;i < arr.length;++i)
			arr[i] = i*arr[i];
		
		int temp[] = new int[arr.length];
		
		return mergeSort(arr,temp,0,arr.length-1);
	}
	
	public static int mergeSort(int arr[],int temp[],int left,int right){
		
		int invCount = 0;
		if(left < right){
			int mid = (left+(right-left)/2);
			invCount = mergeSort(arr, temp, left, mid);
			invCount += mergeSort(arr, temp, mid+1, right);
			invCount += merge(arr,temp,left,mid+1,right);
		}
		return invCount;
	}
	
	public static int merge(int arr[],int temp[],int left,int mid,int right){
		
		int i = left,j = mid;
		int k = left;
		int invCount = 0;
		
		while(i < mid && j <= right){
			if(arr[i] <= arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
				invCount += (mid-i);
			}
		}
		
		while(i < mid)
			temp[k++] = arr[i++];
		
		while(j <= right)
			temp[k++] = arr[j++];
		
		for(i = left;i <= right;++i)
			arr[i] = temp[i];
		
		return invCount;
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {5, 0, 10, 2, 4, 1, 6};
		System.out.println(inversionCount(arr));

	}

}
