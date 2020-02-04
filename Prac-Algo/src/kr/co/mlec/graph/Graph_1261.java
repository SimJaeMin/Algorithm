package kr.co.mlec.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Pair12 implements Comparable<Pair12> { //우선순위 큐를 위해 Comparable<Pair12>
	
	int x;
	int y;
	int z;

	public Pair12(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(Pair12 o) { //this가 작거나 같으면 올림차순  this.z >= o.z ? 1: -1 ;
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
		PriorityQueue<Pair12> pq = new PriorityQueue<Pair12>(); // 우선순위 큐 생성
		pq.add(new Pair12(1,1,0));	//시작과 거기는 뿌신수는 0임	

		if(n==1 && m==1 ) { //1,1 은 항상 열려있으니까 0을 출력하고 끝냄
			System.out.println(0);
			return;
		}
		while (!pq.isEmpty()) {
			Pair12 next = pq.poll();

			for (int i = 0; i < 4; i++) { // 4방향으로 움직일수 있음
				int nextX = next.x + x[i];
				int nextY = next.y + y[i];
				int nextZ = next.z; // 현재까지 최소거리

				if (nextX == m && nextY == n) { // n,m을 찾으면 그때 벽을 뿌순 수 출력
					System.out.println(next.z);
					return;
				}
				
				if (nextX > 0 && nextY > 0 && nextX <= m && nextY <= n) {
					if (data[nextX][nextY] == 1 && check[nextX][nextY]==false) { // 우선순위 큐라 그냥 bfs하듯 해주면된다.
						//우선순위 큐로 해줬기 때문에 그 지점을 방문했을때 최소값일수밖에없음
						//자기자신을 방문하기 전이 방문했던 최소의수로 정렬을한 우선순위 큐이기 때문임
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
