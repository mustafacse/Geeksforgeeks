package org.mohsin.geek.Graph;

import java.util.Iterator;

public class DFS {

	public static void dfs(Graph g){
		
		int v = g.getV();
		boolean visited[] = new boolean[v];
		
		for(int i = 0;i < v;++i){
			if(!visited[i])
				dfsUtil(g,i,visited);
		}
	}
	
	public static void dfsUtil(Graph g,int v,boolean visited[]){
		
		visited[v] = true;
		System.out.println(v);
		
		Iterator<Integer> itr = g.getNodes(v).iterator();
		while(itr.hasNext()){
			int i = itr.next();
			if(!visited[i])
				dfsUtil(g, i, visited);
		}
	}
	
	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		dfs(g);
	}

}
