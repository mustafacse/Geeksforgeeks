package org.mohsin.geek.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Tnode {
	int data;
	Tnode left, right;
	int vd;
	
	public Tnode(int data){
		this.data = data;
		
	}
}

public class DiagonalSum {

	private static HashMap<Integer, Integer> hm = new HashMap<>();

	public static void diagonalSum(Tnode root) {

		if (root == null)
			return;

		root.vd = 0;
		Queue<Tnode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			Tnode curr = q.remove();
			int vd = curr.vd;
			while (curr != null) {

				int prev = hm.get(vd) == null ? 0 : hm.get(vd);
				hm.put(vd, prev + curr.data);

				if (curr.left != null) {
					curr.left.vd = vd + 1;
					q.add(curr.left);
				}

				curr = curr.right;
			}
		}
	}

	public static void main(String[] args) {

		Tnode root = new Tnode(1);
		root.left = new Tnode(2);
		root.right = new Tnode(3);
		root.left.left = new Tnode(9);
		root.left.right = new Tnode(6);
		root.right.left = new Tnode(4);
		root.right.right = new Tnode(5);
		root.right.left.left = new Tnode(12);
		root.right.left.right = new Tnode(7);
		root.left.right.left = new Tnode(11);
		root.left.left.right = new Tnode(10);
		
		diagonalSum(root);
		System.out.println(hm.entrySet());
	}

}
