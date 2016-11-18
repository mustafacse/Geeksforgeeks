/**
 * 
 */
package org.mohsin.geek.Graph;

import java.util.LinkedList;

/**
 * @author Mohsin
 *
 */
public class Graph {

	private int v;
	private LinkedList<Integer> arr[];
	
	public Graph(int v) {
		super();
		this.v = v;
		arr = new LinkedList[this.v];
		for(int i = 0;i < this.v;++i){
			arr[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u,int v){
		arr[u].add(v);
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public LinkedList<Integer>[] getArr() {
		return arr;
	}

	public void setArr(LinkedList<Integer>[] arr) {
		this.arr = arr;
	}
	
	public LinkedList<Integer> getNodes(int i){
		return arr[i];
	}
}
