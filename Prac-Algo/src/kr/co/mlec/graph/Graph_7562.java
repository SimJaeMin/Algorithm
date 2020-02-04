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
			q.add(new Pair2(first, second)); // 초기 시작 장소 큐에 삽입
			check[first][second]=true;
			
			int destX = sc.nextInt();
			int destY = sc.nextInt();
			
			if(first==destX && second == destY) {
				System.out.println(0);
				test--;
				continue; // break; 를 쓰면 while 문을 완전 나가버린다.
			}
			
			while (!q.isEmpty() && tf) {
				int a = q.peek().x; // 현재 장소를
				int b = q.peek().y; // 현재장소
				q.poll();
				
				for (int i = 0; i < 8; i++) {
					int nextX = a + x[i]; //현재장소에서 움직일 수 있는 곳은 8 곳이 있다
					int nextY = b + y[i];
					if (nextX > -1 && nextY > -1 && nextX < num && nextY < num && map[nextX][nextY] == 0) { // 만약 이동할 수 있으면
					
						map[nextX][nextY] = map[a][b] + 1; // 이동할 장소는 현재장소에서 한번더 이동한거니까 현재 장소의 이동거리 에다가 + 1 을 해준다. 
						if (nextX == destX && nextY == destY) { // 만약 그 곳이 도착지라면 출력
							System.out.println(map[nextX][nextY]);
							tf = false;
							break;
						}
						q.add(new Pair2(nextX, nextY)); // 도착지가 아니라면 큐에 추가해준다.
					//	check[nextX][nextY]=true;
					}
				}
			}
			test--;
		}
		
	}
}
