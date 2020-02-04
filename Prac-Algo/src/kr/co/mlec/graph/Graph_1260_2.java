package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_1260_2 {

	static public void dfs(int start) {
		check[start] = true;
		System.out.print(start + " ");

		for (int i = 0; i < a[start].size(); i++) {
			int next = a[start].get(i);

			if (check[next] == true) {
				continue;
			}
			
			dfs(next);
		}
	}

	static public void bfs(int start) {
		q.add(start);
		check[start] = true;

		while (!q.isEmpty()) {
			int next = q.poll();
			System.out.print(next + " ");

			for (int i = 0; i < a[next].size(); i++) {
				int num = a[next].get(i);
				if (check[num] == false) {
					check[num] = true;
					q.add(num);
				}
			}

		}
	}

	static Queue<Integer> q;
	static ArrayList<Integer> a[];
	static boolean check[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();
		int edge = sc.nextInt();
		int start = sc.nextInt();

		a = (ArrayList<Integer>[]) new ArrayList[node + 1];
		check = new boolean[node + 1];
		q = new LinkedList<Integer>();
		for (int i = 0; i <= node; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edge; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			a[first].add(second);
			a[second].add(first);
		}
		for (int i = 1; i <= node; i++) {
			Collections.sort(a[i]);
		}

		dfs(start);

		for (int i = 1; i <= node; i++) {
			check[i] = false;
		}
		
		System.out.println();
		bfs(start);

	}
}
