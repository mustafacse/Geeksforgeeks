/**
 * 
 */
package org.mohsin.geek.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mohsin
 *
 */
public class BFS {

	public static void bfs(Graph g,int s){
		
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		
		boolean visited[] = new boolean[g.getV()];
		visited[s] = true;
		
		while(!q.isEmpty()){
			int curr = q.remove();
			System.out.print(curr+"->");
			
			LinkedList<Integer> nodes = g.getNodes(curr);
			Iterator<Integer> itr = nodes.iterator();
			while(itr.hasNext()){
				int val = itr.next();
				if(!visited[val]){
					visited[val] = true;
					q.add(val);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		bfs(g,2);
	}

}
