package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pa {
	int x;
	int y;

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

	public Pa(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pa() {
	}

}

public class Graph_7576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int count = 0;
		int max = 0;
		int data[][];
		int map[][];
		int x[] = { -1, 1, 0, 0 };
		int y[] = { 0, 0, -1, 1 };
		Queue<Pa> q;
		
		data = new int[n][m];
		map = new int[n][m];
		q = new LinkedList<Pa>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				data[i][j] = sc.nextInt();
				if (data[i][j] == 1) {
					q.add(new Pa(i, j)); // 처음에 익은 토마토가 여러개면 그 중 한개가 실행될 때 인접한 익지않은 토마토들 보다 먼저 실행되야해서 처음에 익은 토마토를 먼저 큐에 삽입ㄴ
				}
			}
		}

		while (!q.isEmpty()) {

			int g = q.peek().getX();
			int h = q.peek().getY();
			q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = g + x[i];
				int nextY = h + y[i];

				if (nextX > -1 && nextY > -1 && nextX < n && nextY < m && data[nextX][nextY] == 0
						&& map[nextX][nextY]==0) {
					q.add(new Pa(nextX, nextY));
					map[nextX][nextY] = map[g][h] + 1;
				}
			}
		}


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j]==0 && data[i][j] == 0) {
					max=-1;
					i=n+1;
					j=m+1;
					break;
				}
				if (max < map[i][j]) {
					max = map[i][j];
				}
			}
		}
		
		System.out.println(max);
	}
}