package org.mohsin.geek.List;

import java.util.HashMap;

class LNode{
	private int data;
	private LNode next;
	private LNode random;
	public LNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LNode getNext() {
		return next;
	}
	public void setNext(LNode next) {
		this.next = next;
	}
	public LNode getRandom() {
		return random;
	}
	public void setRandom(LNode random) {
		this.random = random;
	}
	
	
}
public class CloneList {

	private static HashMap<LNode,LNode> hm = new HashMap<LNode,LNode>();
	
	public static void createNodes(LNode head)
	{
		while(head != null){
			LNode newNode = new LNode(head.getData());
			hm.put(head,newNode);
			head = head.getNext();
		}
	}
	
	public static void copyLinks(LNode head)
	{
		while(head != null){
			LNode newNode = hm.get(head);
			newNode.setRandom(hm.get(head.getRandom()));
			newNode.setNext(hm.get(head.getNext()));
			head = head.getNext();
		}
	}
	
	public static LNode cloneList(LNode head){
		LNode curr = head;
		createNodes(curr);
		copyLinks(curr);
		return hm.get(head);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
