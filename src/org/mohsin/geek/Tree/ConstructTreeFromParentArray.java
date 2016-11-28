/**
 * 
 */
package org.mohsin.geek.Tree;

/**
 * @author mohsin
 *
 */
public class ConstructTreeFromParentArray {

	private static TreeNode root = null;
	
	public static void construct(int parent[],int i,TreeNode created[]){
		
		if(created[i] != null)
			return;
		
		created[i] = new TreeNode(i);
		
		if(parent[i] == -1)
		{
			root = created[i];
			return;
		}
		
		if(created[parent[i]] == null)
			construct(parent,parent[i],created);
		
		TreeNode p = created[parent[i]];
		if(p.getLeft() == null)
			p.setLeft(created[i]);
		else
			p.setRight(created[i]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int parent[] =  {-1, 0, 0, 1, 1, 3, 5};
		TreeNode created[] = new TreeNode[parent.length];
		
		for(int i = 0;i < parent.length;++i)
			construct(parent, i, created);
		root.inorder(root);

	}

}
