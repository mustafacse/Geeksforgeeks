package org.mohsin.geek.String;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import org.mohsin.geek.Graph.Graph;

public class AlienLanguage {

	private static Stack<Integer> s = new Stack<>();
	
	public static void topologicalSort(Graph g){
		
		int v = g.getV();
		boolean visited[] = new boolean[v];
		
		
		for(int i = 0;i < v;++i){
			if(!visited[i])
				topologicalSortUtil(g,visited,i);
		}
		
		while(!s.empty()){
			System.out.println((char)('a'+s.pop()));
		}
	}
	
	public static void topologicalSortUtil(Graph g,boolean visited[],int v){
		
		visited[v] = true;
		
		LinkedList<Integer> arr = g.getNodes(v);
		Iterator<Integer> itr = arr.iterator();
		while(itr.hasNext()){
			int u = itr.next();
			if(!visited[u])
				topologicalSortUtil(g, visited, u);
		}
		s.push(v);
	}
	
	public static void orderCharacter(String arr[],int num){
		
		Graph g = new Graph(num);
		for(int i = 0;i < arr.length-1;++i){
			String word1 = arr[i];
			String word2 = arr[i+1];
			
			int min = Math.min(word1.length(), word2.length());
			for(int j = 0;j < min;++j){
				if(word1.charAt(j) != word2.charAt(j)){
					g.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
					break;
				}
			}
		}
		
		topologicalSort(g);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String words[] = {"caa", "aaa", "aab"};
		 orderCharacter(words, 3);
	}

}
