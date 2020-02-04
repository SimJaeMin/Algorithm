package kr.co.mlec.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Graph_16947 {
	static ArrayList<Integer> a[];
	static Vector<Integer> v;
	static int check[];
	static int swi = 0;
	static int n;
	static int dist[];
	
	static int dfs(int x, int p) {
	
	    if (check[x] == 1) {
	        return x;
	    }
	    check[x] = 1;
	    for (int y : a[x]) {
	        if (y == p) continue;
	        int res = dfs(y, x);
	        
	        if (res == -2) return -2;
	        if (res >= 0) {
	            check[x] = 2;
	            if (x == res) return -2;
	            else return res;
	        }
	    }
	    return -1;
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(System.in);
		v = new Vector<Integer>();
		n = sc.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[n + 1];
		dist = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			a[start].add(end);
			a[end].add(start);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(a[i]);
		}
		check = new int[n + 1];
		dfs(1, -1);

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (check[i] == 2) {
				dist[i] = 0;
				q.add(i);
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print("I : " + i + "        ");
			System.out.println(check[i]);
		}

		while (!q.isEmpty()) {
			int next = q.poll();
			for (int i = 0; i < a[next].size(); i++) {
				int num = a[next].get(i);
				if (check[num] == 2 || dist[num] > 0) {
					continue;
				} else {
					dist[num] = dist[next] + 1;
					q.add(num);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(dist[i] + " ");
		}
	}
}
