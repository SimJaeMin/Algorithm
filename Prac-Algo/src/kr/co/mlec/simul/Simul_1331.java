package kr.co.mlec.simul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Simul_1331 {
	static int x[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int y[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static Vector<String> v;
	static boolean check[][];
	static boolean t = true;

	public static void go(int sx, int sy, int cnt) {
		if (cnt >= 37) {
			return;
		}

		if (cnt == 36) { // cnt�� 36�̸� 35���� ���� ���ؼ� 35��°���� 0��°�ŷ� �����ִ����� üũ����ߵ�
			cnt = 0;
		}
		for (int i = 0; i < 8; i++) {
			int nextX = sx + x[i];
			int nextY = sy + y[i];

			if (nextX > -1 && nextY > -1 && nextX < 6 && nextY < 6 && check[nextX][nextY] == false) { // �̵������� �����̰�
																										// ���� �ѹ���
																										// �̵����� ����
																										// ���̸� ���µ�

				if (nextX == v.get(cnt).charAt(0) - 'A' && nextY == v.get(cnt).charAt(1) - '1') { // �� ���� �Է¹޾Ҵ�
																									// cnt��°��
																									// �Ȱ�����
					check[nextX][nextY] = true; // �̹� ���� �湮üũ�ϰ�
					if (cnt == 0) {
						return;
					} else {
						go(nextX, nextY, cnt + 1); // ����������
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = new Stack<String>();
		check = new boolean[6][6]; // �湮 �迭 üũ
		for (int i = 0; i < 36; i++) { // Input �Է�
			v.add(br.readLine());
		}

		int startX = v.get(0).charAt(0) - 'A'; // �Է¹��� ù��° ���ҿ��� ���� int ������ �ٲ��ֱ�
		int startY = v.get(0).charAt(1) - '1'; // �Է¹����� �ٲ��ֱ�

		go(startX, startY, 1); // 0 ��°�Ŵ� �����ϱ� 1��°���� ����

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (check[i][j] == false) { // �ϳ��� �湮 �ȵ�������
					System.out.println("Invalid"); // �ȵǴ°�
					return; // ������
				}
			}
		}
		System.out.println("Valid"); // ���� �� �湮������ �湮�Ϸ�

	}
}
