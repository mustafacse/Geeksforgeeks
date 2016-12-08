package org.mohsin.geek.Graph;

import java.util.Arrays;

public class PrimsAlgoForMst {

	public static void prim(int graph[][]){
		
		int v = graph.length;
		int parent[] = new int[v];
		int key[] = new int[v];
		boolean mst[] = new boolean[v];
		
		Arrays.fill(parent, -1);
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[0] = 0;
		parent[0] = -1;
		
		for(int count = 0;count < v-1;++count){
			int u = find(mst,key);
			mst[u] = true;
			for(int i = 0;i < v;++i){
				if(graph[u][i] != 0 && !mst[i] && key[i] > graph[u][i]){
					parent[i] = u;
					key[i] = graph[u][i];
				}
			}
		}
		
		for(int i = 0;i < v;++i){
			System.out.println(key[i]+" "+parent[i]);
		}
	}
	
	public static int find(boolean mst[],int key[]){
		
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0;i < mst.length;++i){
			if(!mst[i] && key[i] < min)
			{
				min = key[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		
		int graph[][] = {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
               };
		
		prim(graph);

	}

}
