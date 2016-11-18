package org.geek.mohsin.interviews.N301;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class W1Node implements Comparable<W1Node>{
	int index;
	String str;
	
	public W1Node(int i,String temp){
		index = i;
		str = new String(temp);
	}

	@Override
	public int compareTo(W1Node second) {
		if(this.str.compareTo(second.str) < 0)
			return -1;
		else if(this.str.compareTo(second.str) > 0)
			return 1;
		return 0;
	}
}

public class W1Q1 {

	public static void putAnagramsTogether(String arr[]){
		
		LinkedList<W1Node> list = new LinkedList<>();
		
		
		for(int i = 0;i < arr.length;++i){
			list.add(new W1Node(i, arr[i]));
		}
		
		for(int i = 0;i < list.size();++i){
			W1Node curr = list.get(i);
			char temp[] = curr.str.toCharArray();
			Arrays.sort(temp);
			curr.str = new String(temp);
		}
		
		
		
		Collections.sort(list);
		
		/*for(int i = 0;i < list.size();++i){
			W1Node curr = list.get(i);
			System.out.println(curr.str+" "+curr.index);
			
		}*/
		
		for(int i = 0;i < arr.length;++i){
			System.out.print(arr[list.get(i).index]+" ");
		}
		
	}
	public static void main(String[] args) {
		
		String wordArr[] = {"cat", "dog", "tac", "god", "act"};

		putAnagramsTogether(wordArr);
	}

}
