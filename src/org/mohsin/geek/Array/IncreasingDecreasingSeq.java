package org.mohsin.geek.Array;

import java.util.ArrayList;
import java.util.Iterator;

public class IncreasingDecreasingSeq {

	public static ArrayList<Integer> seq(String str){
		
		ArrayList<Integer> res = new ArrayList<>();
		int posI = 0,minAvail = 0;
		
		if(str.charAt(0) == 'I'){
			res.add(1);
			res.add(2);
			minAvail = 3;
			posI = 1;
		}else{
			res.add(2);
			res.add(1);
			minAvail = 3;
			posI = 0;
		}
		
		int len = str.length();
		
		for(int i = 1;i < len;++i){
			if(str.charAt(i) == 'I'){
				res.add(minAvail);
				posI = i+1;
				minAvail += 1;
			}else{
				res.add(res.get(i));
				for(int j = posI; j <= i;++j)
				{
					int val = res.get(j)+1;
					res.set(j, val);
				}
				minAvail += 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		String str = "DDIDDIID";
		ArrayList<Integer> res = seq(str);
		
		Iterator<Integer> itr = res.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next());
		}

	}

}
