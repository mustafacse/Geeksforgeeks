package org.mohsin.geek.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

	public static boolean isBipartite(int graph[][]){
		
		int color[] = new int[graph.length];
		Arrays.fill(color, -1);
		
		color[0] = 1;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()){
			int u = q.remove();
			
			for(int v = 0;v < graph.length;++v){
				if(graph[u][v] != 0 && color[v] == -1){
					color[v] = 1 - color[u];
					q.add(v);
				}
				else if(graph[u][v] != 0 && color[u] == color[v])
					return false;
			} 
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		int G[][] = {{0, 1, 0, 1},
		        {1, 0, 1, 0},
		        {0, 1, 0, 1},
		        {1, 0, 1, 0}
		    };

		if(isBipartite(G))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
