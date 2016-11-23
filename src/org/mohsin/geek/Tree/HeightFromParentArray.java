package org.mohsin.geek.Tree;

public class HeightFromParentArray {

	
	public static void depthArray(int parent[],int depth[],int index){
		
		if(depth[index] != 0)
			return;
		
		if(parent[index] == -1)
		{
			depth[index] = 1;
			return ;
		}
		
		if(depth[parent[index]] == 0)
			depthArray(parent, depth, parent[index]);
		
		depth[index] = depth[parent[index]]+1;
	}
	
	public static int getHeight(int parent[]){
		
		int depth[] = new int[parent.length];
		
		for(int i = 0;i < depth.length;++i)
			depthArray(parent, depth, i);
		
		int ht = depth[0];
		for(int i = 1;i < depth.length;++i){
			if(ht < depth[i])
				ht = depth[i];
		}
		return ht;
	}
	
	public static void main(String[] args) {
		
		 int parent[] = {-1, 0, 0, 1, 1, 3, 5};
		 
		 System.out.println(getHeight(parent));

	}

}
