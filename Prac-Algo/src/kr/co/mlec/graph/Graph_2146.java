package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair123 {
	int x;
	int y;

	public Pair123(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair123() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

public class Graph_2146 {
	static int data[][];
	static int map[][];
	static int x[] = { -1, 1, 0, 0 };
	static int y[] = { 0, 0, -1, 1 };
	static boolean check[][];
	static int map1[][];

	public static void dfs(int n, int a, int b, int cnt) {
		check[a][b] = true;
		map[a][b] = cnt;
		for (int i = 0; i < 4; i++) {
			int nextX = a + x[i];
			int nextY = b + y[i];

			if (nextX > -1 && nextY > -1 && nextX < n && nextY < n && data[nextX][nextY] == 1
					&& check[nextX][nextY] == false) {
				map[nextX][nextY] = cnt;
				dfs(n, nextX, nextY, cnt);
			}
		}
	}

	public static int bfs(int cnt, int n) {
		Queue<Pair123> q = new LinkedList<Pair123>();
		int num = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == cnt) {
					q.add(new Pair123(i, j));
					check[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {

			int size = q.size();

			for (int a = 0; a < size; a++) {
				
				Pair123 next = q.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = next.getX() + x[i];
					int nextY = next.getY() + y[i];

					if (nextX > -1 && nextY > -1 && nextX < n && nextY < n && check[nextX][nextY] == false) {
						if (map[nextX][nextY] == 0) {
							check[nextX][nextY] = true;
							q.add(new Pair123(nextX, nextY));
						} else{
							return num;
						}
					}
				}
			}
			num++;
		}
		return num;
	}

	public static void main(String[] args) {
		Queue<Pair123> q = new LinkedList<Pair123>();

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new int[n][n];
		map1 = new int[n][n];
		data = new int[n][n];
		check = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = sc.nextInt();
				data[i][j] = num;
			}
		}

		int cnt = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j] == false && data[i][j] == 1) {
					dfs(n, i, j, cnt);
					cnt++;
				}
			}
		}
		
		int min = 0;
		for (int i = 1; i < cnt  ; i++) {

			check = new boolean[n][n];
			int res = bfs(i, n);
			
			if (i == 1) {
				min = res;
			} else {
				if (min > res) {
					min = res;
				}
			}
		}
		System.out.println(min);
	}
}
