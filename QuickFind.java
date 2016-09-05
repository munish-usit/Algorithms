/* Quick Find Algortihm
 * In array we create set of connected components. Connected components have same id.
 * union(first,second) we assign id of second object to id of first object id[first] = id[second]
 * While updating id[first], then all objects which have id = id of first object are also changed.
 * M Find Operation on N objects = O(M) 
 * M Union Operation on N objects = O(MN) = O(N*N) = Quadratic
 */
package com.princeton.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class QuickFind {
	int [] id;
	public QuickFind(int n)
	{
		id = new int[n];
		for(int i=0; i<id.length; i++) id[i] = i;
	}
	public boolean find (int p, int q)
	{
		return(id[p]==id[q]);
	}
	public void union (int p, int q)
	{
		int pid = id[p]; // storing id[p] because its value can change in loop
		for(int i=0; i<id.length; i++) {
			if(id[i] == pid) id[i] = id[q];
		}
	}
	public static void main(String [] args) {
		System.out.println("Enter Array Size and Union Commands");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		QuickFind quf = new QuickFind(n);
		//System.out.println("Array size "+n);
		while(!scan.hasNext("Find")) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			if(!quf.find(p,q)) {
				quf.union(p,q);
				//System.out.println("p q "+p+" "+q);
			}
		}
		scan.close();
		// Checking find result
		System.out.println(quf.find(2, 4));
		System.out.println(quf.find(5, 6));
		System.out.println(Arrays.toString(quf.id));
		
	}
}
