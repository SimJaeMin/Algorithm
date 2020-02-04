package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Graph_16964 {
	static ArrayList<Integer> a[];
	static int data[];
	static int subSize[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[n + 1];
		data = new int[n];
		subSize= new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			a[first].add(second);
			a[second].add(first);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(a[i]);
		}
		
		for(int i=1;i<=n;i++) {
			subSize[i] = a[i].size()+1;
		}
		for(int i=0;i<n;i++) {
			data[i]=sc.nextInt();
		}
		 
		
		
		
		
	}
}
