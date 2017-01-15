/**
 * 
 */
package org.mohsin.geek.Array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author mohsin
 *
 */
public class LazyLoading {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new FileReader("E:\\Workspace\\Geeksforgeeks\\IOFiles\\lazyLoading.txt"));
		PrintWriter writer = new PrintWriter("E:\\Workspace\\Geeksforgeeks\\IOFiles\\output.txt");
		
		int t,n;
		int index = 0,trip = 0,left = 0,right = 0;
		int arr[] = new int[101];
		int res = 1;
		t = Integer.parseInt(reader.readLine());
		while(t > 0){
			
			n = Integer.parseInt(reader.readLine());
			index = 0;
			while(n > 0){
				arr[index++] = Integer.parseInt(reader.readLine());
				--n;
			}
			
			Arrays.sort(arr, 0, index);
			
			/*for(int i = 0;i < index;++i)
				System.out.print(arr[i]+" ");*/
			
			
			left = 0;
			right = index-1;
			trip = 0;
			int counter = 0;
			while(left < right){
				int top = arr[right];
				counter = 1;
				while(top  < 50){
					top += top;
					++counter;
				}
				
				//System.out.println(counter);
				
				if(right-left+1 >= counter){
					++trip;
					--right;
					left += (counter-1);
				}
				else
					break;
			}
			
			writer.println("Case #"+res+": "+trip);
			++res;
			--t;
		}
		
		reader.close();
		writer.close();
	}

}
