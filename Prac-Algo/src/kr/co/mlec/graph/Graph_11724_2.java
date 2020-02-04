package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_11724_2 {
	static ArrayList<Integer> a[];
	static boolean check[];
	static int count = 0;
	static Queue<Integer> q;

	public static void dfs(int start) {
		check[start] = true;

		for (int i = 0; i < a[start].size(); i++) {
			int next = a[start].get(i);

			if (check[next] == false) {
				dfs(next);
			}
		}
	}

	public static void bfs(int start) {
		q.add(start);
		check[start] = true;

		while (!q.isEmpty()) {
			int next = q.poll();

			for (int i = 0; i < a[next].size(); i++) {
				int x = a[next].get(i);
				if (check[x] == false) {
					q.add(x);
					check[x] = true;
				}
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();
		int edge = sc.nextInt();

		a = (ArrayList<Integer>[]) new ArrayList[node + 1];
		check = new boolean[node + 1];
		q = new LinkedList<Integer>();
		for (int i = 1; i <= node; i++) {
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

		for (int i = 1; i <= node; i++) {
			if (check[i] == false) {
				count++;
				// dfs(i);
				bfs(i);
			}
		}
		System.out.println(count);
	}
}
