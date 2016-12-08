package org.mohsin.geek.Matrix;

class HeapNode{
	int data;
	int i;
	int j;
	
	public HeapNode(int x,int i,int j){
		this.data = x;
		this.i = i;
		this.j = j;
	}
}


public class PrintMatirxInSortedOrder {

	public static void buildHeap(HeapNode arr[]){
		
		int i = (arr.length-1)/2;
		while(i >= 0){
			minHeapify(arr,i);
			--i;
		}
	}
	
	public static void minHeapify(HeapNode arr[],int i){
		
		int smallest = i;
		int left = i*2+1;
		int right = i*2+2;
		
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
	
	public static void printSorted(int mat[][]){
		
		int row = mat.length;
		int col = mat[0].length;
		
		HeapNode arr[] = new HeapNode[row];
		
		for(int i = 0;i < row;++i){
			arr[i] = new HeapNode(mat[i][0],i,1);
		}
		
		buildHeap(arr);
		
		for(int count = 0;count < row*col;++count){
			
			HeapNode root = arr[0];
			System.out.print(root.data+" ");
			
			if(root.j < col){
				root.data = mat[root.i][root.j];
				 root.j += 1;
				arr[0] = root;
			}else{
				root.data = Integer.MAX_VALUE;
			}
			
			minHeapify(arr, 0);
		}
	}
	
	public static void main(String[] args) {
		
		int mat[][] = { {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},
              };
		
		printSorted(mat);

	}

}
