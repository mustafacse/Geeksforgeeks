package org.mohsin.geek.Matrix;
class Hnode{
    int i,j;
    int data;
    
    public Hnode(int x,int y,int key){
        i = x;
        j = y;
        data = key;
    }
}
public class KthInMatrix {

	public static void buildHeap(Hnode arr[]){
        int n = arr.length;
        for(int i = 0;i <= (n-1)/2;++i)
            minHeapify(arr,i);
    }
    
    public static void minHeapify(Hnode arr[],int index){
        int left = 2*index+1;
        int right = 2*index+2;
        int smallest = index;
        
        if(left < arr.length && arr[left].data < arr[smallest].data)
            smallest = left;
        if(right < arr.length && arr[right].data < arr[smallest].data)
            smallest = right;
        if(smallest != index){
            Hnode temp = arr[index];
            arr[index] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(arr,smallest);
        }
    }
    
	public static void kthSmallest(int[][] a,int n,int k){
    
     Hnode heap[] = new Hnode[n];
     for(int i = 0;i < n;++i){
         heap[i] = new Hnode(i,1,a[i][0]);
     }
     
     buildHeap(heap);
     Hnode root = null;
     for(int i = 0;i < k;++i){
         root = heap[0];
         if(i == k-1)
        	 break;
         if(root.j >= n)
            root.data = Integer.MAX_VALUE;
         else{
             root.data = a[root.i][root.j];
             root.j += 1;
             heap[0] = root;
             minHeapify(heap,0);
         }
     }
     if(root != null)
        System.out.println(root.data);
     else System.out.println(-1);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{10, 20, 30, 40},
	        {15, 25, 35, 45},
	        {24, 29, 37, 48},
	        {32, 33, 39, 50}};
		kthSmallest(mat, 4, 4);
	}

}
