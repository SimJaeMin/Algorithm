package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Pair12 implements Comparable<Pair12> { //�켱���� ť�� ���� Comparable<Pair12>
	
	int x;
	int y;
	int z;

	public Pair12(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(Pair12 o) { //this�� �۰ų� ������ �ø�����  this.z >= o.z ? 1: -1 ;
		return this.z >= o.z ? 1 : -1;
	}

}
public class Graph_1261 {
	static int data[][];
	static int x[] = { 0, -1, 0, 1 };
	static int y[] = { 1, 0, -1, 0 };
	static boolean check[][];
	static int dist[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		data = new int[m + 1][n + 1];
		check = new boolean[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			String s = sc.next();
			for (int j = 1; j <= n; j++) {
				data[i][j] = s.charAt(j - 1) - '0';
			}
		}
		PriorityQueue<Pair12> pq = new PriorityQueue<Pair12>(); // �켱���� ť ����
		pq.add(new Pair12(1,1,0));	//���۰� �ű�� �ѽż��� 0��	

		if(n==1 && m==1 ) { //1,1 �� �׻� ���������ϱ� 0�� ����ϰ� ����
			System.out.println(0);
			return;
		}
		while (!pq.isEmpty()) {
			Pair12 next = pq.poll();

			for (int i = 0; i < 4; i++) { // 4�������� �����ϼ� ����
				int nextX = next.x + x[i];
				int nextY = next.y + y[i];
				int nextZ = next.z; // ������� �ּҰŸ�

				if (nextX == m && nextY == n) { // n,m�� ã���� �׶� ���� �Ѽ� �� ���
					System.out.println(next.z);
					return;
				}
				
				if (nextX > 0 && nextY > 0 && nextX <= m && nextY <= n) {
					if (data[nextX][nextY] == 1 && check[nextX][nextY]==false) { // �켱���� ť�� �׳� bfs�ϵ� ���ָ�ȴ�.
						//�켱���� ť�� ����� ������ �� ������ �湮������ �ּҰ��ϼ��ۿ�����
						//�ڱ��ڽ��� �湮�ϱ� ���� �湮�ߴ� �ּ��Ǽ��� �������� �켱���� ť�̱� ������
						pq.add(new Pair12(nextX, nextY, nextZ + 1));
						check[nextX][nextY]=true;
					} 
					
					if(data[nextX][nextY]==0 && check[nextX][nextY]==false) {
						pq.add(new Pair12(nextX, nextY, next.z));
						check[nextX][nextY] = true;
					}
				}

			}
		}

		
	}
}
