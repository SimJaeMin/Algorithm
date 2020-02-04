package kr.co.mlec.graph;

import java.util.Scanner;

public class Graph_16929 {
	static char data[][];
	static int count = 0;
	static boolean check[][];
	static int x[] = { -1, 1, 0, 0 };
	static int y[] = { 0, 0, -1, 1 };
	static int solve = 0;
	static int solve1;

	public static void dfs(int n, int m,int start1, int start2, int count, int startX, int startY) {
		check[start1][start2] = true; // ������ üũ
		for (int i = 0; i < 4; i++) {
			if (solve == 0) { // ����Ŭ�� ã���� for���� �׸��ϱ�����
				int nextX = start1 + x[i];
				int nextY = start2 + y[i];
				
				if (count >= 3 && nextX == startX && nextY == startY) { // count�� 3�̻��̸� ó������ 4�������� �̵��ѰŴϱ� �׶����� ó������ ���ƿ´ٸ� ����Ŭ����
					solve = 1;
					solve1 = count;
					return;
				}
				
				if (nextX > -1 && nextY > -1 && nextX < n && nextY < m && data[nextX][nextY] == data[startX][startY]
						&& check[nextX][nextY] == false) { // �������°��� �����ְ�, ó�� �����Ϳ� �Ȱ��� ���̶�� ����
					dfs(n,m,nextX, nextY, count + 1, startX, startY);
				}
			}
		}
		check[start1][start2] = false; // ó�� �����ϴ°����E�ȵɼ��� �����ϱ� ���������ٽ� false�� �������
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		data = new char[n][m];
		check = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				data[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (solve == 0) {
					dfs(n, m, i,j,0, i, j);
				}
			}
		}

		if (solve == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
