package kr.co.mlec.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair2 {
	int x;
	int y;

	Pair2(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class Graph_7562 {
	static int map[][];
	static boolean check[][];
	static Queue<Pair2> q;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		int x[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int y[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		
		while (test > 0) {
			q = new LinkedList<Pair2>();
			int num = sc.nextInt();
			check = new boolean[num][num];
			map = new int[num][num];
		
			int first = sc.nextInt();
			int second = sc.nextInt();
			
			boolean tf = true;
			q.add(new Pair2(first, second)); // �ʱ� ���� ��� ť�� ����
			check[first][second]=true;
			
			int destX = sc.nextInt();
			int destY = sc.nextInt();
			
			if(first==destX && second == destY) {
				System.out.println(0);
				test--;
				continue; // break; �� ���� while ���� ���� ����������.
			}
			
			while (!q.isEmpty() && tf) {
				int a = q.peek().x; // ���� ��Ҹ�
				int b = q.peek().y; // �������
				q.poll();
				
				for (int i = 0; i < 8; i++) {
					int nextX = a + x[i]; //������ҿ��� ������ �� �ִ� ���� 8 ���� �ִ�
					int nextY = b + y[i];
					if (nextX > -1 && nextY > -1 && nextX < num && nextY < num && map[nextX][nextY] == 0) { // ���� �̵��� �� ������
					
						map[nextX][nextY] = map[a][b] + 1; // �̵��� ��Ҵ� ������ҿ��� �ѹ��� �̵��ѰŴϱ� ���� ����� �̵��Ÿ� ���ٰ� + 1 �� ���ش�. 
						if (nextX == destX && nextY == destY) { // ���� �� ���� ��������� ���
							System.out.println(map[nextX][nextY]);
							tf = false;
							break;
						}
						q.add(new Pair2(nextX, nextY)); // �������� �ƴ϶�� ť�� �߰����ش�.
					//	check[nextX][nextY]=true;
					}
				}
			}
			test--;
		}
		
	}
}
