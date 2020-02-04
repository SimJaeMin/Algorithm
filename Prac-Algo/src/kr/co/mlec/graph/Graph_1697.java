package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph_1697 {
	static int dist[];
	static boolean check[];

	public static void go() {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		dist = new int[100001];
		check = new boolean[100001];

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		check[n] = true;
		if (n == k) { //처음부터 같은 장소에있으면 0 출력
			System.out.println(0);
			return;
		}
		int num = -1;
		boolean t=true;
		while (!q.isEmpty() && t) {
			int size = q.size();
			num++;
			for (int i = 0; i < size; i++) { // 한번에 3군대를 갈수있으니 3군대에서 갈수있는 경우의수를 다 해보고 없으면 거리를 + 1 해주기 위해
				int start = q.poll();
				check[start] = true;

				if (start - 1 > -1 && check[start - 1] == false) { //이동 가능한 거리고 아직 방문 안한 자리라면
					q.add(start - 1);
				}

				if (start + 1 <= 100000 && check[start + 1] == false) {
					q.add(start + 1);
				}
				if (start * 2 <= 100000 && check[start * 2] == false) {
					q.add(start * 2);
				}
				if (start == k) {
					t=false; // 찾으면 break로 for문 탈출하고 t 로 while문 탈출
					break;
				}
			}
		}
		System.out.println(num); // num 출력
	}	
}
