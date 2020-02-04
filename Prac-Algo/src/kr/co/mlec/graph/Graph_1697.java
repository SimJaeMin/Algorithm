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
		if (n == k) { //ó������ ���� ��ҿ������� 0 ���
			System.out.println(0);
			return;
		}
		int num = -1;
		boolean t=true;
		while (!q.isEmpty() && t) {
			int size = q.size();
			num++;
			for (int i = 0; i < size; i++) { // �ѹ��� 3���븦 ���������� 3���뿡�� �����ִ� ����Ǽ��� �� �غ��� ������ �Ÿ��� + 1 ���ֱ� ����
				int start = q.poll();
				check[start] = true;

				if (start - 1 > -1 && check[start - 1] == false) { //�̵� ������ �Ÿ��� ���� �湮 ���� �ڸ����
					q.add(start - 1);
				}

				if (start + 1 <= 100000 && check[start + 1] == false) {
					q.add(start + 1);
				}
				if (start * 2 <= 100000 && check[start * 2] == false) {
					q.add(start * 2);
				}
				if (start == k) {
					t=false; // ã���� break�� for�� Ż���ϰ� t �� while�� Ż��
					break;
				}
			}
		}
		System.out.println(num); // num ���
	}	
}
