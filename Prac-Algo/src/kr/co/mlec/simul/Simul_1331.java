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

		if (cnt == 36) { // cnt가 36이면 35번쨰 까지 다해서 35번째에서 0번째거로 갈수있는지를 체크해줘야됨
			cnt = 0;
		}
		for (int i = 0; i < 8; i++) {
			int nextX = sx + x[i];
			int nextY = sy + y[i];

			if (nextX > -1 && nextY > -1 && nextX < 6 && nextY < 6 && check[nextX][nextY] == false) { // 이동가능한 범위이고
																										// 아직 한번도
																										// 이동하지 않은
																										// 곳이면 가는데

				if (nextX == v.get(cnt).charAt(0) - 'A' && nextY == v.get(cnt).charAt(1) - '1') { // 그 곳이 입력받았던
																									// cnt번째와
																									// 똑같으면
					check[nextX][nextY] = true; // 이번 곳을 방문체크하고
					if (cnt == 0) {
						return;
					} else {
						go(nextX, nextY, cnt + 1); // 다음곳으로
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = new Stack<String>();
		check = new boolean[6][6]; // 방문 배열 체크
		for (int i = 0; i < 36; i++) { // Input 입력
			v.add(br.readLine());
		}

		int startX = v.get(0).charAt(0) - 'A'; // 입력받은 첫번째 원소에서 시작 int 형으로 바꿔주기
		int startY = v.get(0).charAt(1) - '1'; // 입력받은거 바꿔주기

		go(startX, startY, 1); // 0 번째거는 했으니까 1번째부터 시작

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (check[i][j] == false) { // 하나라도 방문 안되있으면
					System.out.println("Invalid"); // 안되는거
					return; // 끝내기
				}
			}
		}
		System.out.println("Valid"); // 모든거 다 방문했으면 방문완료

	}
}
