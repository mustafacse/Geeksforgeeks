package org.mohsin.geek.Array;

class HeapNode{
	int data;
	int i;
	int j;
	
	public HeapNode(int data,int x,int y){
		this.data = data;
		i = x;
		j = y;
	}
}


public class MinRange {

	public static void buildHeap(HeapNode arr[]){
		
		int i = (arr.length-1)/2;
		while(i >= 0){
			minHeapify(arr,i);
			--i;
		}
	}
	
	public static void minHeapify(HeapNode arr[],int i){
		int smallest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < arr.length && arr[left].data < arr[smallest].data)
			smallest = left;
		if(right < arr.length && arr[right].data < arr[smallest].data)
			smallest = right;
		
		if(smallest != i){
			HeapNode temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			minHeapify(arr, smallest);
		}
	}
	
	public static void minrange(int list[][]){
		
		HeapNode arr[] = new HeapNode[list.length];
		
		int max = 0;
		int start = 0,end = 0;
		int range = Integer.MAX_VALUE;
		
		for(int i = 0;i < list.length;++i){
			arr[i] = new HeapNode(list[i][0],i,1);
			if(max < list[i][0])
				max = list[i][0];
		}
		
		
		buildHeap(arr);
		
		while(true){
			
			HeapNode root = arr[0];
			int min = root.data;
			
			
			if(max-min+1 < range){
				range = max-min+1;
				start = min;
				end = max;
			}
			
			int j = root.j;
			if(j == list[0].length)
				break;
			HeapNode temp = new HeapNode(list[root.i][root.j],root.i,root.j+1);
			if(temp.data > max)
				max = temp.data;
			replaceMin(arr,temp);
		}
		
		System.out.println(start+" "+end);
		
	}
	
	public static void replaceMin(HeapNode arr[],HeapNode temp){
		
		arr[0] = temp;
		minHeapify(arr, 0);
	}
	
	public static void main(String[] args) {
		
		int arr[][] = {
                {4, 7, 9, 12, 15},
                {0, 8, 10, 14, 20},
                {6, 12, 16, 30, 50}
                };
		
		minrange(arr);

	}

}
